package cn.rlfit.gulimallcoupon.service;

import cn.rlfit.gulimall.to.SkuReduction;
import cn.rlfit.gulimallcoupon.domain.SmsSkuFullReduction;
import java.util.List;
    /**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 31/03/2024 1:16 PM
 */
public interface SmsSkuFullReductionService{

    int deleteByPrimaryKey(Long id);

    int insert(SmsSkuFullReduction record);

    int insertSelective(SmsSkuFullReduction record);

    SmsSkuFullReduction selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SmsSkuFullReduction record);

    int updateByPrimaryKey(SmsSkuFullReduction record);

    int batchInsert(List<SmsSkuFullReduction> list);

        void saveSkuReduciton(SkuReduction skuReduction);
    }
