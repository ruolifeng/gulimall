package cn.rlfit.gulimallware.service.impl;

import cn.rlfit.gulimall.constant.WareConstant;
import cn.rlfit.gulimallware.entity.Purchase;
import cn.rlfit.gulimallware.entity.PurchaseDetail;
import cn.rlfit.gulimallware.entity.table.PurchaseTableDef;
import cn.rlfit.gulimallware.mapper.PurchaseMapper;
import cn.rlfit.gulimallware.service.PurchaseDetailService;
import cn.rlfit.gulimallware.service.PurchaseService;
import cn.rlfit.gulimallware.vo.MergeVo;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.util.StringUtil;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
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

    @Transactional
    @Override
    public void merge(MergeVo mergeVo) {
        Long purchaseId = mergeVo.getPurchaseId();
        if (purchaseId == null){
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
}
