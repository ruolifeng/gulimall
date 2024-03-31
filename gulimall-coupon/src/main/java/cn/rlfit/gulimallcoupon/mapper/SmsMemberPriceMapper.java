package cn.rlfit.gulimallcoupon.mapper;

import cn.rlfit.gulimallcoupon.domain.SmsMemberPrice;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 31/03/2024 1:10 PM
 */
@Mapper
public interface SmsMemberPriceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SmsMemberPrice record);

    int insertSelective(SmsMemberPrice record);

    SmsMemberPrice selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SmsMemberPrice record);

    int updateByPrimaryKey(SmsMemberPrice record);

    int batchInsert(@Param("list") List<SmsMemberPrice> list);
}