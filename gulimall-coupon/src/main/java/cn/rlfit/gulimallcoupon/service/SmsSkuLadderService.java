package cn.rlfit.gulimallcoupon.service;

import java.util.List;
import cn.rlfit.gulimallcoupon.domain.SmsSkuLadder;
    /**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 31/03/2024 1:17 PM
 */
public interface SmsSkuLadderService{

    int deleteByPrimaryKey(Long id);

    int insert(SmsSkuLadder record);

    int insertSelective(SmsSkuLadder record);

    SmsSkuLadder selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SmsSkuLadder record);

    int updateByPrimaryKey(SmsSkuLadder record);

    int batchInsert(List<SmsSkuLadder> list);

}
