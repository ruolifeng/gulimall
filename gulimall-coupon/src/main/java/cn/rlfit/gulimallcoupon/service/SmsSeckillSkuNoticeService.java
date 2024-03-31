package cn.rlfit.gulimallcoupon.service;

import cn.rlfit.gulimallcoupon.domain.SmsSeckillSkuNotice;
import java.util.List;
    /**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 31/03/2024 1:13 PM
 */
public interface SmsSeckillSkuNoticeService{

    int deleteByPrimaryKey(Long id);

    int insert(SmsSeckillSkuNotice record);

    int insertSelective(SmsSeckillSkuNotice record);

    SmsSeckillSkuNotice selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SmsSeckillSkuNotice record);

    int updateByPrimaryKey(SmsSeckillSkuNotice record);

    int batchInsert(List<SmsSeckillSkuNotice> list);

}
