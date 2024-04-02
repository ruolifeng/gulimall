package cn.rlfit.gulimallware.service.impl;

import cn.rlfit.gulimallware.entity.PurchaseDetail;
import cn.rlfit.gulimallware.entity.table.PurchaseDetailTableDef;
import cn.rlfit.gulimallware.mapper.PurchaseDetailMapper;
import cn.rlfit.gulimallware.service.PurchaseDetailService;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.util.StringUtil;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Map;

/**
 *  服务层实现。
 *
 * @author ruolifeng
 * @since 2024-04-01 12:37:31
 */
@Service
public class PurchaseDetailServiceImpl extends ServiceImpl<PurchaseDetailMapper, PurchaseDetail> implements PurchaseDetailService {
    @Override
    public Page<PurchaseDetail> pageListAll(Map<String, Object> pms) {
        Page<PurchaseDetail> page = new Page<>();
        page.setPageSize(Long.parseLong((String) pms.get("limit")));
        page.setPageNumber(Long.parseLong((String) pms.get("page")));
        QueryWrapper wrapper = QueryWrapper.create()
                .select()
                .from(PurchaseDetailTableDef.PURCHASE_DETAIL)
                .where(PurchaseDetailTableDef.PURCHASE_DETAIL.STATUS.eq(pms.get("status")).when(!StringUtil.isNotBlank((String) pms.get("status"))))
                .and(PurchaseDetailTableDef.PURCHASE_DETAIL.WARE_ID.eq(pms.get("wareId")).when(!StringUtil.isNotBlank((String) pms.get("wareId"))))
                .and(PurchaseDetailTableDef.PURCHASE_DETAIL.ID.eq(pms.get("key")).when(StringUtil.isNotBlank((String) pms.get("key"))));
        return page(page, wrapper);
    }

    @Override
    public void deleteAll(Long[] ids) {
        this.removeByIds(Arrays.stream(ids).toList());
    }
}
