package cn.rlfit.gulimallcoupon.mapper;

import cn.rlfit.gulimallcoupon.domain.SmsSkuFullReduction;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 31/03/2024 1:16 PM
 */
@Mapper
public interface SmsSkuFullReductionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SmsSkuFullReduction record);

    int insertSelective(SmsSkuFullReduction record);

    SmsSkuFullReduction selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SmsSkuFullReduction record);

    int updateByPrimaryKey(SmsSkuFullReduction record);

    int batchInsert(@Param("list") List<SmsSkuFullReduction> list);
}