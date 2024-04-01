package cn.rlfit.gulimallware.service.impl;

import cn.rlfit.gulimallware.entity.WareInfo;
import cn.rlfit.gulimallware.entity.table.WareInfoTableDef;
import cn.rlfit.gulimallware.mapper.WareInfoMapper;
import cn.rlfit.gulimallware.service.WareInfoService;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Map;

/**
 * 仓库信息 服务层实现。
 *
 * @author ruolifeng
 * @since 2024-04-01 12:37:31
 */
@Service
public class WareInfoServiceImpl extends ServiceImpl<WareInfoMapper, WareInfo> implements WareInfoService {

    @Override
    public Page<WareInfo> GetFoPage(Map<String, Object> pms) {
        Page<WareInfo> page = new Page<>();
        QueryWrapper queryWrapper = null;
                String key = null;
        if (pms.get("page") != null)
            page.setPageNumber(Integer.parseInt((String) pms.get("page")));
        if (pms.get("limit") != null)
            page.setPageSize(Integer.parseInt((String) pms.get("limit")));
        if (pms.get("key") != null && pms.get("key") != ""){
            key = (String) pms.get("key");
            queryWrapper = QueryWrapper.create().select()
                    .from(WareInfoTableDef.WARE_INFO)
                    .and(WareInfoTableDef.WARE_INFO.ID.eq(key)
                            .or(WareInfoTableDef.WARE_INFO.NAME.like(key))
                            .or(WareInfoTableDef.WARE_INFO.ADDRESS.like(key)));
            return page(page, queryWrapper);
        }
        return page(page);

    }

    @Override
    public void patchDelete(Long[] ids) {
        this.removeByIds(Arrays.stream(ids).toList());
    }
}
