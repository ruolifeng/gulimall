package cn.rlfit.gulimallware.service.impl;

import cn.rlfit.gulimall.constant.WareConstant;
import cn.rlfit.gulimallware.entity.Purchase;
import cn.rlfit.gulimallware.entity.PurchaseDetail;
import cn.rlfit.gulimallware.entity.table.PurchaseTableDef;
import cn.rlfit.gulimallware.mapper.PurchaseMapper;
import cn.rlfit.gulimallware.service.PurchaseDetailService;
import cn.rlfit.gulimallware.service.PurchaseService;
import cn.rlfit.gulimallware.service.WareSkuService;
import cn.rlfit.gulimallware.vo.ItemDoneVo;
import cn.rlfit.gulimallware.vo.MergeVo;
import cn.rlfit.gulimallware.vo.PurchaseDoneVo;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.util.StringUtil;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 采购信息 服务层实现。
 *
 * @author ruolifeng
 * @since 2024-04-01 12:37:31
 */
@Service
public class PurchaseServiceImpl extends ServiceImpl<PurchaseMapper, Purchase> implements PurchaseService {
    @Autowired
    PurchaseDetailService purchaseDetailService;
    @Autowired
    WareSkuService wareSkuService;

    @Override
    public Page<Purchase> pageListAll(Map<String, Object> pms) {
        Page<Purchase> page = new Page<>();
        page.setPageSize(Long.parseLong((String) pms.get("limit")));
        page.setPageNumber(Long.parseLong((String) pms.get("page")));
        QueryWrapper wrapper = QueryWrapper.create()
                .select()
                .from(PurchaseTableDef.PURCHASE)
                .where(PurchaseTableDef.PURCHASE.ID.eq(pms.get("key")).when(StringUtil.isNotBlank((String) pms.get("key"))));
        return this.page(page, wrapper);
    }

    @Override
    public void deleteAll(Long[] ids) {
        this.removeByIds(Arrays.stream(ids).toList());
    }

    @Override
    public Page<Purchase> unreceiveList(Map<String, Object> pms) {
        Page<Purchase> page = new Page<>();
        QueryWrapper wrapper = QueryWrapper.create()
                .select()
                .from(PurchaseTableDef.PURCHASE)
                .where(PurchaseTableDef.PURCHASE.STATUS.eq(0))
                .or(PurchaseTableDef.PURCHASE.STATUS.eq(1));
        return page(page, wrapper);
    }

    // TODO 确认采购单状态是0,1才可以合并
    @Transactional
    @Override
    public void merge(MergeVo mergeVo) {
        Long purchaseId = mergeVo.getPurchaseId();
        if (purchaseId == null) {
            Purchase purchase = new Purchase();
            purchase.setStatus(WareConstant.CREATED.getCode());
            purchase.setCreateTime(LocalDateTime.now());
            purchase.setUpdateTime(LocalDateTime.now());
            this.save(purchase);
            purchaseId = purchase.getId();
        }
        List<Long> items = mergeVo.getItems();
        Long finalPurchaseId = purchaseId;
        List<PurchaseDetail> collect = items.stream().map(x -> {
            PurchaseDetail purchaseDetail = new PurchaseDetail();
            purchaseDetail.setId(x);
            purchaseDetail.setPurchaseId(finalPurchaseId);
            purchaseDetail.setStatus(WareConstant.ASSIGNED.getCode());
            return purchaseDetail;
        }).collect(Collectors.toList());
        purchaseDetailService.updateBatch(collect);
        Purchase purchase = new Purchase();
        purchase.setId(purchaseId);
        purchase.setUpdateTime(LocalDateTime.now());
        this.updateById(purchase);
    }

    @Override
    public void recevied(Long[] ids) {
        // 确认当前采购单是新建或者已近分配状态
        List<Purchase> purchaseList = Arrays.stream(ids).map(this::getById).filter(item -> item.getStatus() == WareConstant.CREATED.getCode()
                || item.getStatus() == WareConstant.ASSIGNED.getCode()).peek(item -> {
            item.setStatus(WareConstant.RECEIVE.getCode());
            item.setUpdateTime(LocalDateTime.now());
        }).toList();
        // 改变采购单的状态
        this.updateBatch(purchaseList);
        // 改变采购项的状态
        purchaseList.forEach(item -> {
            List<PurchaseDetail> purchaseDetailList = purchaseDetailService.listDetailByPurchaseId(item.getId());
            List<PurchaseDetail> purchaseDetails = purchaseDetailList.stream().map(x -> {
                PurchaseDetail purchaseDetail = new PurchaseDetail();
                purchaseDetail.setId(x.getId());
                purchaseDetail.setStatus(WareConstant.RECEIVE.getCode());
                return purchaseDetail;
            }).collect(Collectors.toList());
            purchaseDetailService.updateBatch(purchaseDetails);
        });
    }

    @Transactional
    @Override
    public void done(PurchaseDoneVo purchaseDoneVo) {
        // 改变采购单状态
        Long id = purchaseDoneVo.getId();
        // 改变采购单中每一个项的状态
        Boolean flag = true;
        List<ItemDoneVo> items = purchaseDoneVo.getItems();
        List<PurchaseDetail> update = new ArrayList<>();
        for (ItemDoneVo item : items) {
            PurchaseDetail purchaseDetail = new PurchaseDetail();
            if (item.getStatus() == WareConstant.HASERROR.getCode()) {
                flag = false;
                purchaseDetail.setStatus(WareConstant.HASERROR.getCode());
            } else {
                purchaseDetail.setStatus(WareConstant.FINISH.getCode());
                PurchaseDetail byId = purchaseDetailService.getById(item.getItemId());
                wareSkuService.addStock(byId.getSkuId(),byId.getWareId(),byId.getSkuNum());
            }
            purchaseDetail.setId(item.getItemId());
            update.add(purchaseDetail);
        }
        purchaseDetailService.updateBatch(update);
        Purchase purchase = new Purchase();
        purchase.setId(id);
        purchase.setStatus(false?WareConstant.FINISH.getCode() : WareConstant.HASERROR.getCode());
        purchase.setUpdateTime(LocalDateTime.now());
        this.updateById(purchase);
        // 将成功采购的进行入库
    }
}
