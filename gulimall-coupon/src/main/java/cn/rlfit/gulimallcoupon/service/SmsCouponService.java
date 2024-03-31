package cn.rlfit.gulimallcoupon.service;

import java.util.List;
import cn.rlfit.gulimallcoupon.domain.SmsCoupon;
    /**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 31/03/2024 1:09 PM
 */
public interface SmsCouponService{

    int deleteByPrimaryKey(Long id);

    int insert(SmsCoupon record);

    int insertSelective(SmsCoupon record);

    SmsCoupon selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SmsCoupon record);

    int updateByPrimaryKey(SmsCoupon record);

    int batchInsert(List<SmsCoupon> list);

}
