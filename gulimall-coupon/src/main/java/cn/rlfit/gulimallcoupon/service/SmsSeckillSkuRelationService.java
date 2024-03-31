package cn.rlfit.gulimallcoupon.service;

import java.util.List;
import cn.rlfit.gulimallcoupon.domain.SmsSeckillSkuRelation;
    /**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 31/03/2024 1:15 PM
 */
public interface SmsSeckillSkuRelationService{

    int deleteByPrimaryKey(Long id);

    int insert(SmsSeckillSkuRelation record);

    int insertSelective(SmsSeckillSkuRelation record);

    SmsSeckillSkuRelation selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SmsSeckillSkuRelation record);

    int updateByPrimaryKey(SmsSeckillSkuRelation record);

    int batchInsert(List<SmsSeckillSkuRelation> list);

}
