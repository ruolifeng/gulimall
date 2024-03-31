package cn.rlfit.gulimallcoupon.service.impl;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import cn.rlfit.gulimallcoupon.mapper.SmsSeckillSessionMapper;
import cn.rlfit.gulimallcoupon.domain.SmsSeckillSession;
import cn.rlfit.gulimallcoupon.service.SmsSeckillSessionService;
/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 31/03/2024 1:11 PM
 */
@Service
public class SmsSeckillSessionServiceImpl implements SmsSeckillSessionService{

    @Autowired
    private SmsSeckillSessionMapper smsSeckillSessionMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return smsSeckillSessionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SmsSeckillSession record) {
        return smsSeckillSessionMapper.insert(record);
    }

    @Override
    public int insertSelective(SmsSeckillSession record) {
        return smsSeckillSessionMapper.insertSelective(record);
    }

    @Override
    public SmsSeckillSession selectByPrimaryKey(Long id) {
        return smsSeckillSessionMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SmsSeckillSession record) {
        return smsSeckillSessionMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SmsSeckillSession record) {
        return smsSeckillSessionMapper.updateByPrimaryKey(record);
    }

    @Override
    public int batchInsert(List<SmsSeckillSession> list) {
        return smsSeckillSessionMapper.batchInsert(list);
    }

}
