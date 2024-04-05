package cn.rlfit.gulimallware.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.mybatisflex.core.BaseMapper;
import cn.rlfit.gulimallware.entity.WareInfo;

/**
 * 仓库信息 映射层。
 *
 * @author ruolifeng
 * @since 2024-04-04 18:02:29
 */
@Mapper
public interface WareInfoMapper extends BaseMapper<WareInfo> {

}
