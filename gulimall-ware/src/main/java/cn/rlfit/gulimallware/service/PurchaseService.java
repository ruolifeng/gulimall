package cn.rlfit.gulimallware.service;

import cn.rlfit.gulimallware.entity.Purchase;
import cn.rlfit.gulimallware.vo.MergeVo;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.service.IService;

import java.util.Map;

/**
 * 采购信息 服务层。
 *
 * @author ruolifeng
 * @since 2024-04-01 12:37:31
 */
public interface PurchaseService extends IService<Purchase> {
    Page<Purchase> pageListAll(Map<String, Object> pms);

    void deleteAll(Long[] ids);

    Page<Purchase> unreceiveList(Map<String, Object> pms);

    void merge(MergeVo mergeVo);

//    Page<Purchase> pageListAll(Map<String, Object> pms);
//
//    void deleteAll(Long[] ids);
}
