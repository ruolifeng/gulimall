package cn.rlfit.gulimallware.mapper;

import cn.rlfit.gulimallware.entity.WareSku;
import com.mybatisflex.core.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 商品库存 映射层。
 *
 * @author ruolifeng
 * @since 2024-04-01 12:37:31
 */
@Mapper
public interface WareSkuMapper extends BaseMapper<WareSku> {
    void addStock(@Param("skuId") Long skuId,
                  @Param("wareId") Long wareId,
                  @Param("skuNum") Integer skuNum);
}
