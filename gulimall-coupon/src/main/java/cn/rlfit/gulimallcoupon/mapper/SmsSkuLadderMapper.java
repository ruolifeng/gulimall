package cn.rlfit.gulimallcoupon.mapper;

import cn.rlfit.gulimallcoupon.domain.SmsSkuLadder;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 31/03/2024 1:17 PM
 */
@Mapper
public interface SmsSkuLadderMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SmsSkuLadder record);

    int insertSelective(SmsSkuLadder record);

    SmsSkuLadder selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SmsSkuLadder record);

    int updateByPrimaryKey(SmsSkuLadder record);

    int batchInsert(@Param("list") List<SmsSkuLadder> list);
}