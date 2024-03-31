package cn.rlfit.gulimallcoupon.mapper;

import cn.rlfit.gulimallcoupon.domain.SmsSeckillSkuRelation;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 31/03/2024 1:15 PM
 */
@Mapper
public interface SmsSeckillSkuRelationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SmsSeckillSkuRelation record);

    int insertSelective(SmsSeckillSkuRelation record);

    SmsSeckillSkuRelation selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SmsSeckillSkuRelation record);

    int updateByPrimaryKey(SmsSeckillSkuRelation record);

    int batchInsert(@Param("list") List<SmsSeckillSkuRelation> list);
}