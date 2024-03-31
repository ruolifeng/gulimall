package cn.rlfit.gulimallcoupon.mapper;

import cn.rlfit.gulimallcoupon.domain.SmsCouponSpuCategoryRelation;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 31/03/2024 1:10 PM
 */
@Mapper
public interface SmsCouponSpuCategoryRelationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SmsCouponSpuCategoryRelation record);

    int insertSelective(SmsCouponSpuCategoryRelation record);

    SmsCouponSpuCategoryRelation selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SmsCouponSpuCategoryRelation record);

    int updateByPrimaryKey(SmsCouponSpuCategoryRelation record);

    int batchInsert(@Param("list") List<SmsCouponSpuCategoryRelation> list);
}