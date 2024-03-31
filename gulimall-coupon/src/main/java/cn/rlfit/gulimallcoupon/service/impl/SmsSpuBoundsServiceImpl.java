package cn.rlfit.gulimallcoupon.service.impl;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import cn.rlfit.gulimallcoupon.domain.SmsSpuBounds;
import java.util.List;
import cn.rlfit.gulimallcoupon.mapper.SmsSpuBoundsMapper;
import cn.rlfit.gulimallcoupon.service.SmsSpuBoundsService;
/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 31/03/2024 1:17 PM
 */
@Service
public class SmsSpuBoundsServiceImpl implements SmsSpuBoundsService{

    @Autowired
    private SmsSpuBoundsMapper smsSpuBoundsMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return smsSpuBoundsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SmsSpuBounds record) {
        return smsSpuBoundsMapper.insert(record);
    }

    @Override
    public int insertSelective(SmsSpuBounds record) {
        return smsSpuBoundsMapper.insertSelective(record);
    }

    @Override
    public SmsSpuBounds selectByPrimaryKey(Long id) {
        return smsSpuBoundsMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SmsSpuBounds record) {
        return smsSpuBoundsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SmsSpuBounds record) {
        return smsSpuBoundsMapper.updateByPrimaryKey(record);
    }

    @Override
    public int batchInsert(List<SmsSpuBounds> list) {
        return smsSpuBoundsMapper.batchInsert(list);
    }

}
