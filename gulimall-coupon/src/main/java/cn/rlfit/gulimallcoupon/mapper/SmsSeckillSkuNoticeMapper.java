package cn.rlfit.gulimallcoupon.mapper;

import cn.rlfit.gulimallcoupon.domain.SmsSeckillSkuNotice;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 31/03/2024 1:13 PM
 */
@Mapper
public interface SmsSeckillSkuNoticeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SmsSeckillSkuNotice record);

    int insertSelective(SmsSeckillSkuNotice record);

    SmsSeckillSkuNotice selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SmsSeckillSkuNotice record);

    int updateByPrimaryKey(SmsSeckillSkuNotice record);

    int batchInsert(@Param("list") List<SmsSeckillSkuNotice> list);
}