package cn.rlfit.gulimallware.service;

import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.service.IService;
import cn.rlfit.gulimallware.entity.WareSku;

import java.util.Map;

/**
 * 商品库存 服务层。
 *
 * @author ruolifeng
 * @since 2024-04-01 12:37:31
 */
public interface WareSkuService extends IService<WareSku> {

    Page<WareSku> queryPage(Map<String, Object> pms);

    void patchDelete(Long[] ids);
}
