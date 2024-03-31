package cn.rlfit.gulimallcoupon.service.impl;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import cn.rlfit.gulimallcoupon.mapper.SmsSkuLadderMapper;
import java.util.List;
import cn.rlfit.gulimallcoupon.domain.SmsSkuLadder;
import cn.rlfit.gulimallcoupon.service.SmsSkuLadderService;
/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 31/03/2024 1:17 PM
 */
@Service
public class SmsSkuLadderServiceImpl implements SmsSkuLadderService{

    @Autowired
    private SmsSkuLadderMapper smsSkuLadderMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return smsSkuLadderMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SmsSkuLadder record) {
        return smsSkuLadderMapper.insert(record);
    }

    @Override
    public int insertSelective(SmsSkuLadder record) {
        return smsSkuLadderMapper.insertSelective(record);
    }

    @Override
    public SmsSkuLadder selectByPrimaryKey(Long id) {
        return smsSkuLadderMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SmsSkuLadder record) {
        return smsSkuLadderMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SmsSkuLadder record) {
        return smsSkuLadderMapper.updateByPrimaryKey(record);
    }

    @Override
    public int batchInsert(List<SmsSkuLadder> list) {
        return smsSkuLadderMapper.batchInsert(list);
    }

}
