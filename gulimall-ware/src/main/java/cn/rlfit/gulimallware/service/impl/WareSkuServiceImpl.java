package cn.rlfit.gulimallware.service.impl;

import cn.rlfit.gulimall.utils.resp.R;
import cn.rlfit.gulimallware.entity.WareSku;
import cn.rlfit.gulimallware.entity.table.WareSkuTableDef;
import cn.rlfit.gulimallware.feign.ProductFeignService;
import cn.rlfit.gulimallware.mapper.WareSkuMapper;
import cn.rlfit.gulimallware.service.WareSkuService;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.util.StringUtil;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 商品库存 服务层实现。
 *
 * @author ruolifeng
 * @since 2024-04-01 12:37:31
 */
@Service
public class WareSkuServiceImpl extends ServiceImpl<WareSkuMapper, WareSku> implements WareSkuService {
    @Autowired
    WareSkuMapper wareSkuDao;
    @Autowired
    ProductFeignService productFeignService;

    @Override
    public Page<WareSku> queryPage(Map<String, Object> pms) {
        Page<WareSku> wareSkuPage = new Page<>();
        wareSkuPage.setPageSize(Long.parseLong((String) pms.get("limit")));
        wareSkuPage.setPageNumber(Long.parseLong((String) pms.get("page")));
        QueryWrapper wrapper = QueryWrapper.create()
                .select()
                .from(WareSkuTableDef.WARE_SKU)
                .where(WareSkuTableDef.WARE_SKU.WARE_ID.eq(pms.get("wareId")).when(StringUtil.isNotBlank((String) pms.get("wareId"))))
                .and(WareSkuTableDef.WARE_SKU.SKU_ID.eq(pms.get("skuId")).when(StringUtil.isNotBlank((String) pms.get("skuId"))));
        return page(wareSkuPage, wrapper);
    }

    @Override
    public void patchDelete(Long[] ids) {
        this.removeByIds(Arrays.stream(ids).toList());
    }

    @Override
    public void addStock(Long skuId, Long wareId, Integer skuNum) {
        // 判断是不是此操作
        List<WareSku> wareSkus = wareSkuDao.selectListByQuery(QueryWrapper.create().select()
                .from(WareSkuTableDef.WARE_SKU)
                .where(WareSkuTableDef.WARE_SKU.SKU_ID.eq(skuId))
                .and(WareSkuTableDef.WARE_SKU.WARE_ID.eq(wareId)));
        if (wareSkus == null || wareSkus.isEmpty()) {
            WareSku wareSku = new WareSku();
            wareSku.setSkuId(skuId);
            wareSku.setStock(skuNum);
            wareSku.setWareId(wareId);
            wareSku.setStock(0);
            try {
                R info = productFeignService.info(skuId);
                Map<String, Object> data = (Map<String, Object>) info.get("data");
                if (info.getCode() == 0)
                    wareSku.setSkuName((String) data.get("skuName"));
            } catch (Exception e) {

            }
            wareSkuDao.insert(wareSku);
        } else {
            wareSkuDao.addStock(skuId, wareId, skuNum);
        }
    }
}
