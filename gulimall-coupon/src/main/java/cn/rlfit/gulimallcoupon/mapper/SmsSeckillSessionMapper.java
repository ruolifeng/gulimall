package cn.rlfit.gulimallcoupon.mapper;

import cn.rlfit.gulimallcoupon.domain.SmsSeckillSession;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 31/03/2024 1:11 PM
 */
@Mapper
public interface SmsSeckillSessionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SmsSeckillSession record);

    int insertSelective(SmsSeckillSession record);

    SmsSeckillSession selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SmsSeckillSession record);

    int updateByPrimaryKey(SmsSeckillSession record);

    int batchInsert(@Param("list") List<SmsSeckillSession> list);
}