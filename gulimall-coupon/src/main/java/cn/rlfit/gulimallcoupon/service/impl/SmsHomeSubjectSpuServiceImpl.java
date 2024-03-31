package cn.rlfit.gulimallcoupon.service.impl;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import cn.rlfit.gulimallcoupon.domain.SmsHomeSubjectSpu;
import cn.rlfit.gulimallcoupon.mapper.SmsHomeSubjectSpuMapper;
import cn.rlfit.gulimallcoupon.service.SmsHomeSubjectSpuService;
/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 31/03/2024 1:10 PM
 */
@Service
public class SmsHomeSubjectSpuServiceImpl implements SmsHomeSubjectSpuService{

    @Autowired
    private SmsHomeSubjectSpuMapper smsHomeSubjectSpuMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return smsHomeSubjectSpuMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SmsHomeSubjectSpu record) {
        return smsHomeSubjectSpuMapper.insert(record);
    }

    @Override
    public int insertSelective(SmsHomeSubjectSpu record) {
        return smsHomeSubjectSpuMapper.insertSelective(record);
    }

    @Override
    public SmsHomeSubjectSpu selectByPrimaryKey(Long id) {
        return smsHomeSubjectSpuMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SmsHomeSubjectSpu record) {
        return smsHomeSubjectSpuMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SmsHomeSubjectSpu record) {
        return smsHomeSubjectSpuMapper.updateByPrimaryKey(record);
    }

    @Override
    public int batchInsert(List<SmsHomeSubjectSpu> list) {
        return smsHomeSubjectSpuMapper.batchInsert(list);
    }

}
