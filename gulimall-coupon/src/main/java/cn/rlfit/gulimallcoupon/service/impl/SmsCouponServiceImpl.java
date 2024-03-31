package cn.rlfit.gulimallcoupon.service.impl;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import cn.rlfit.gulimallcoupon.mapper.SmsCouponMapper;
import java.util.List;
import cn.rlfit.gulimallcoupon.domain.SmsCoupon;
import cn.rlfit.gulimallcoupon.service.SmsCouponService;
/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 31/03/2024 1:09 PM
 */
@Service
public class SmsCouponServiceImpl implements SmsCouponService{

    @Autowired
    private SmsCouponMapper smsCouponMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return smsCouponMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SmsCoupon record) {
        return smsCouponMapper.insert(record);
    }

    @Override
    public int insertSelective(SmsCoupon record) {
        return smsCouponMapper.insertSelective(record);
    }

    @Override
    public SmsCoupon selectByPrimaryKey(Long id) {
        return smsCouponMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SmsCoupon record) {
        return smsCouponMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SmsCoupon record) {
        return smsCouponMapper.updateByPrimaryKey(record);
    }

    @Override
    public int batchInsert(List<SmsCoupon> list) {
        return smsCouponMapper.batchInsert(list);
    }

}
