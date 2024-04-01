package cn.rlfit.gulimallware.service;

import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.service.IService;
import cn.rlfit.gulimallware.entity.WareInfo;

import java.util.Map;

/**
 * 仓库信息 服务层。
 *
 * @author ruolifeng
 * @since 2024-04-01 12:37:31
 */
public interface WareInfoService extends IService<WareInfo> {

    Page<WareInfo> GetFoPage(Map<String, Object> params);
}
