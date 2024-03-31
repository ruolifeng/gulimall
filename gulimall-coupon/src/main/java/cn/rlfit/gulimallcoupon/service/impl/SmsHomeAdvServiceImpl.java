package cn.rlfit.gulimallcoupon.service.impl;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import cn.rlfit.gulimallcoupon.mapper.SmsHomeAdvMapper;
import java.util.List;
import cn.rlfit.gulimallcoupon.domain.SmsHomeAdv;
import cn.rlfit.gulimallcoupon.service.SmsHomeAdvService;
/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 31/03/2024 1:10 PM
 */
@Service
public class SmsHomeAdvServiceImpl implements SmsHomeAdvService{

    @Autowired
    private SmsHomeAdvMapper smsHomeAdvMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return smsHomeAdvMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SmsHomeAdv record) {
        return smsHomeAdvMapper.insert(record);
    }

    @Override
    public int insertSelective(SmsHomeAdv record) {
        return smsHomeAdvMapper.insertSelective(record);
    }

    @Override
    public SmsHomeAdv selectByPrimaryKey(Long id) {
        return smsHomeAdvMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SmsHomeAdv record) {
        return smsHomeAdvMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SmsHomeAdv record) {
        return smsHomeAdvMapper.updateByPrimaryKey(record);
    }

    @Override
    public int batchInsert(List<SmsHomeAdv> list) {
        return smsHomeAdvMapper.batchInsert(list);
    }

}
