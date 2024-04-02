package cn.rlfit.gulimallware.service;

import cn.rlfit.gulimallware.entity.PurchaseDetail;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.service.IService;

import java.util.Map;

/**
 *  服务层。
 *
 * @author ruolifeng
 * @since 2024-04-01 12:37:31
 */
public interface PurchaseDetailService extends IService<PurchaseDetail> {
    Page<PurchaseDetail> pageListAll(Map<String, Object> pms);

    void deleteAll(Long[] ids);
}
