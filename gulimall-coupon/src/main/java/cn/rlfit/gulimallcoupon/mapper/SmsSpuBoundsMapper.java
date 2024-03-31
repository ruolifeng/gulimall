package cn.rlfit.gulimallcoupon.mapper;

import cn.rlfit.gulimallcoupon.domain.SmsSpuBounds;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 31/03/2024 1:17 PM
 */
@Mapper
public interface SmsSpuBoundsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SmsSpuBounds record);

    int insertSelective(SmsSpuBounds record);

    SmsSpuBounds selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SmsSpuBounds record);

    int updateByPrimaryKey(SmsSpuBounds record);

    int batchInsert(@Param("list") List<SmsSpuBounds> list);
}