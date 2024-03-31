package cn.rlfit.gulimallcoupon.service;

import java.util.List;
import cn.rlfit.gulimallcoupon.domain.SmsCouponSpuRelation;
    /**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 31/03/2024 1:10 PM
 */
public interface SmsCouponSpuRelationService{

    int deleteByPrimaryKey(Long id);

    int insert(SmsCouponSpuRelation record);

    int insertSelective(SmsCouponSpuRelation record);

    SmsCouponSpuRelation selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SmsCouponSpuRelation record);

    int updateByPrimaryKey(SmsCouponSpuRelation record);

    int batchInsert(List<SmsCouponSpuRelation> list);

}
