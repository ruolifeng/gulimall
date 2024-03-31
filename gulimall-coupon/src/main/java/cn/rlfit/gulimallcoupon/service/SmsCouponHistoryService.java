package cn.rlfit.gulimallcoupon.service;

import java.util.List;
import cn.rlfit.gulimallcoupon.domain.SmsCouponHistory;
    /**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 31/03/2024 1:09 PM
 */
public interface SmsCouponHistoryService{

    int deleteByPrimaryKey(Long id);

    int insert(SmsCouponHistory record);

    int insertSelective(SmsCouponHistory record);

    SmsCouponHistory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SmsCouponHistory record);

    int updateByPrimaryKey(SmsCouponHistory record);

    int batchInsert(List<SmsCouponHistory> list);

}
