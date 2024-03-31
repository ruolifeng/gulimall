package cn.rlfit.gulimallcoupon.mapper;

import cn.rlfit.gulimallcoupon.domain.SmsHomeAdv;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 31/03/2024 1:10 PM
 */
@Mapper
public interface SmsHomeAdvMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SmsHomeAdv record);

    int insertSelective(SmsHomeAdv record);

    SmsHomeAdv selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SmsHomeAdv record);

    int updateByPrimaryKey(SmsHomeAdv record);

    int batchInsert(@Param("list") List<SmsHomeAdv> list);
}