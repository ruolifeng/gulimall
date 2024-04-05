package cn.rlfit.gulimallware.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.mybatisflex.core.BaseMapper;
import cn.rlfit.gulimallware.entity.WareSku;

/**
 * 商品库存 映射层。
 *
 * @author ruolifeng
 * @since 2024-04-04 18:02:29
 */
@Mapper
public interface WareSkuMapper extends BaseMapper<WareSku> {

}
