package cn.rlfit.gulimallcoupon.service;

import java.util.List;
import cn.rlfit.gulimallcoupon.domain.SmsHomeAdv;
    /**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 31/03/2024 1:10 PM
 */
public interface SmsHomeAdvService{

    int deleteByPrimaryKey(Long id);

    int insert(SmsHomeAdv record);

    int insertSelective(SmsHomeAdv record);

    SmsHomeAdv selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SmsHomeAdv record);

    int updateByPrimaryKey(SmsHomeAdv record);

    int batchInsert(List<SmsHomeAdv> list);

}
