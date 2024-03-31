package cn.rlfit.gulimallcoupon.service.impl;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import cn.rlfit.gulimallcoupon.domain.SmsSeckillSkuNotice;
import java.util.List;
import cn.rlfit.gulimallcoupon.mapper.SmsSeckillSkuNoticeMapper;
import cn.rlfit.gulimallcoupon.service.SmsSeckillSkuNoticeService;
/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 31/03/2024 1:13 PM
 */
@Service
public class SmsSeckillSkuNoticeServiceImpl implements SmsSeckillSkuNoticeService{

    @Autowired
    private SmsSeckillSkuNoticeMapper smsSeckillSkuNoticeMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return smsSeckillSkuNoticeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SmsSeckillSkuNotice record) {
        return smsSeckillSkuNoticeMapper.insert(record);
    }

    @Override
    public int insertSelective(SmsSeckillSkuNotice record) {
        return smsSeckillSkuNoticeMapper.insertSelective(record);
    }

    @Override
    public SmsSeckillSkuNotice selectByPrimaryKey(Long id) {
        return smsSeckillSkuNoticeMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SmsSeckillSkuNotice record) {
        return smsSeckillSkuNoticeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SmsSeckillSkuNotice record) {
        return smsSeckillSkuNoticeMapper.updateByPrimaryKey(record);
    }

    @Override
    public int batchInsert(List<SmsSeckillSkuNotice> list) {
        return smsSeckillSkuNoticeMapper.batchInsert(list);
    }

}
