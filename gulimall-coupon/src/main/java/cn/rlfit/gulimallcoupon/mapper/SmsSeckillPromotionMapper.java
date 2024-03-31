package cn.rlfit.gulimallcoupon.mapper;

import cn.rlfit.gulimallcoupon.domain.SmsSeckillPromotion;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 31/03/2024 1:10 PM
 */
@Mapper
public interface SmsSeckillPromotionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SmsSeckillPromotion record);

    int insertSelective(SmsSeckillPromotion record);

    SmsSeckillPromotion selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SmsSeckillPromotion record);

    int updateByPrimaryKey(SmsSeckillPromotion record);

    int batchInsert(@Param("list") List<SmsSeckillPromotion> list);
}