package cn.rlfit.gulimallcoupon.service;

import cn.rlfit.gulimallcoupon.domain.SmsSpuBounds;
import java.util.List;
    /**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 31/03/2024 1:17 PM
 */
public interface SmsSpuBoundsService{

    int deleteByPrimaryKey(Long id);

    int insert(SmsSpuBounds record);

    int insertSelective(SmsSpuBounds record);

    SmsSpuBounds selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SmsSpuBounds record);

    int updateByPrimaryKey(SmsSpuBounds record);

    int batchInsert(List<SmsSpuBounds> list);

}
