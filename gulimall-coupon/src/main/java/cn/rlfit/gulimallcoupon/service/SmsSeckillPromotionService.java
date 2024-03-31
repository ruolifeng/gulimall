package cn.rlfit.gulimallcoupon.service;

import java.util.List;
import cn.rlfit.gulimallcoupon.domain.SmsSeckillPromotion;
    /**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 31/03/2024 1:10 PM
 */
public interface SmsSeckillPromotionService{

    int deleteByPrimaryKey(Long id);

    int insert(SmsSeckillPromotion record);

    int insertSelective(SmsSeckillPromotion record);

    SmsSeckillPromotion selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SmsSeckillPromotion record);

    int updateByPrimaryKey(SmsSeckillPromotion record);

    int batchInsert(List<SmsSeckillPromotion> list);

}
