package cn.rlfit.gulimallcoupon.service;

import java.util.List;
import cn.rlfit.gulimallcoupon.domain.SmsMemberPrice;
    /**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 31/03/2024 1:10 PM
 */
public interface SmsMemberPriceService{

    int deleteByPrimaryKey(Long id);

    int insert(SmsMemberPrice record);

    int insertSelective(SmsMemberPrice record);

    SmsMemberPrice selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SmsMemberPrice record);

    int updateByPrimaryKey(SmsMemberPrice record);

    int batchInsert(List<SmsMemberPrice> list);

}
