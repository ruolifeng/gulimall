package cn.rlfit.gulimallcoupon.service.impl;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import cn.rlfit.gulimallcoupon.mapper.SmsCouponHistoryMapper;
import java.util.List;
import cn.rlfit.gulimallcoupon.domain.SmsCouponHistory;
import cn.rlfit.gulimallcoupon.service.SmsCouponHistoryService;
/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 31/03/2024 1:09 PM
 */
@Service
public class SmsCouponHistoryServiceImpl implements SmsCouponHistoryService{

    @Autowired
    private SmsCouponHistoryMapper smsCouponHistoryMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return smsCouponHistoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SmsCouponHistory record) {
        return smsCouponHistoryMapper.insert(record);
    }

    @Override
    public int insertSelective(SmsCouponHistory record) {
        return smsCouponHistoryMapper.insertSelective(record);
    }

    @Override
    public SmsCouponHistory selectByPrimaryKey(Long id) {
        return smsCouponHistoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SmsCouponHistory record) {
        return smsCouponHistoryMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SmsCouponHistory record) {
        return smsCouponHistoryMapper.updateByPrimaryKey(record);
    }

    @Override
    public int batchInsert(List<SmsCouponHistory> list) {
        return smsCouponHistoryMapper.batchInsert(list);
    }

}
