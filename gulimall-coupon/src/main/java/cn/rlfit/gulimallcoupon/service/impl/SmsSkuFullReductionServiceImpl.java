package cn.rlfit.gulimallcoupon.service.impl;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import cn.rlfit.gulimallcoupon.domain.SmsSkuFullReduction;
import java.util.List;
import cn.rlfit.gulimallcoupon.mapper.SmsSkuFullReductionMapper;
import cn.rlfit.gulimallcoupon.service.SmsSkuFullReductionService;
/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 31/03/2024 1:16 PM
 */
@Service
public class SmsSkuFullReductionServiceImpl implements SmsSkuFullReductionService{

    @Autowired
    private SmsSkuFullReductionMapper smsSkuFullReductionMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return smsSkuFullReductionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SmsSkuFullReduction record) {
        return smsSkuFullReductionMapper.insert(record);
    }

    @Override
    public int insertSelective(SmsSkuFullReduction record) {
        return smsSkuFullReductionMapper.insertSelective(record);
    }

    @Override
    public SmsSkuFullReduction selectByPrimaryKey(Long id) {
        return smsSkuFullReductionMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SmsSkuFullReduction record) {
        return smsSkuFullReductionMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SmsSkuFullReduction record) {
        return smsSkuFullReductionMapper.updateByPrimaryKey(record);
    }

    @Override
    public int batchInsert(List<SmsSkuFullReduction> list) {
        return smsSkuFullReductionMapper.batchInsert(list);
    }

}
