package cn.rlfit.gulimallcoupon.service;

import java.util.List;
import cn.rlfit.gulimallcoupon.domain.SmsSeckillSession;
    /**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 31/03/2024 1:11 PM
 */
public interface SmsSeckillSessionService{

    int deleteByPrimaryKey(Long id);

    int insert(SmsSeckillSession record);

    int insertSelective(SmsSeckillSession record);

    SmsSeckillSession selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SmsSeckillSession record);

    int updateByPrimaryKey(SmsSeckillSession record);

    int batchInsert(List<SmsSeckillSession> list);

}
