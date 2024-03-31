package cn.rlfit.gulimallcoupon.service;

import java.util.List;
import cn.rlfit.gulimallcoupon.domain.SmsCouponSpuCategoryRelation;
    /**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 31/03/2024 1:10 PM
 */
public interface SmsCouponSpuCategoryRelationService{

    int deleteByPrimaryKey(Long id);

    int insert(SmsCouponSpuCategoryRelation record);

    int insertSelective(SmsCouponSpuCategoryRelation record);

    SmsCouponSpuCategoryRelation selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SmsCouponSpuCategoryRelation record);

    int updateByPrimaryKey(SmsCouponSpuCategoryRelation record);

    int batchInsert(List<SmsCouponSpuCategoryRelation> list);

}
