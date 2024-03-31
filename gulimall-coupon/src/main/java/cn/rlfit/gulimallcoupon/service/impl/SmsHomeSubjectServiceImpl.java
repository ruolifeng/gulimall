package cn.rlfit.gulimallcoupon.service.impl;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import cn.rlfit.gulimallcoupon.domain.SmsHomeSubject;
import java.util.List;
import cn.rlfit.gulimallcoupon.mapper.SmsHomeSubjectMapper;
import cn.rlfit.gulimallcoupon.service.SmsHomeSubjectService;
/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 31/03/2024 1:10 PM
 */
@Service
public class SmsHomeSubjectServiceImpl implements SmsHomeSubjectService{

    @Autowired
    private SmsHomeSubjectMapper smsHomeSubjectMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return smsHomeSubjectMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SmsHomeSubject record) {
        return smsHomeSubjectMapper.insert(record);
    }

    @Override
    public int insertSelective(SmsHomeSubject record) {
        return smsHomeSubjectMapper.insertSelective(record);
    }

    @Override
    public SmsHomeSubject selectByPrimaryKey(Long id) {
        return smsHomeSubjectMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SmsHomeSubject record) {
        return smsHomeSubjectMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SmsHomeSubject record) {
        return smsHomeSubjectMapper.updateByPrimaryKey(record);
    }

    @Override
    public int batchInsert(List<SmsHomeSubject> list) {
        return smsHomeSubjectMapper.batchInsert(list);
    }

}
