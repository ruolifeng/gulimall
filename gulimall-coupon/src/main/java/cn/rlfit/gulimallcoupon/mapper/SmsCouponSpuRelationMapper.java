package cn.rlfit.gulimallcoupon.mapper;

import cn.rlfit.gulimallcoupon.domain.SmsCouponSpuRelation;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 31/03/2024 1:10 PM
 */
@Mapper
public interface SmsCouponSpuRelationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SmsCouponSpuRelation record);

    int insertSelective(SmsCouponSpuRelation record);

    SmsCouponSpuRelation selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SmsCouponSpuRelation record);

    int updateByPrimaryKey(SmsCouponSpuRelation record);

    int batchInsert(@Param("list") List<SmsCouponSpuRelation> list);
}