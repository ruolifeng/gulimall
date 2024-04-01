package cn.rlfit.gulimallware.service.impl;

import cn.rlfit.gulimallware.entity.WareSku;
import cn.rlfit.gulimallware.entity.table.WareSkuTableDef;
import cn.rlfit.gulimallware.mapper.WareSkuMapper;
import cn.rlfit.gulimallware.service.WareSkuService;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.util.StringUtil;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Map;

/**
 * 商品库存 服务层实现。
 *
 * @author ruolifeng
 * @since 2024-04-01 12:37:31
 */
@Service
public class WareSkuServiceImpl extends ServiceImpl<WareSkuMapper, WareSku> implements WareSkuService {

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
        return page(wareSkuPage,wrapper);
    }

    @Override
    public void patchDelete(Long[] ids) {
        this.removeByIds(Arrays.stream(ids).toList());
    }
}
