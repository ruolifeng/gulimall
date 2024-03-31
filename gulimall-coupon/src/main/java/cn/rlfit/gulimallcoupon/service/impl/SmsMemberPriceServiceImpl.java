package cn.rlfit.gulimallcoupon.service.impl;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import cn.rlfit.gulimallcoupon.mapper.SmsMemberPriceMapper;
import cn.rlfit.gulimallcoupon.domain.SmsMemberPrice;
import cn.rlfit.gulimallcoupon.service.SmsMemberPriceService;
/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 31/03/2024 1:10 PM
 */
@Service
public class SmsMemberPriceServiceImpl implements SmsMemberPriceService{

    @Autowired
    private SmsMemberPriceMapper smsMemberPriceMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return smsMemberPriceMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SmsMemberPrice record) {
        return smsMemberPriceMapper.insert(record);
    }

    @Override
    public int insertSelective(SmsMemberPrice record) {
        return smsMemberPriceMapper.insertSelective(record);
    }

    @Override
    public SmsMemberPrice selectByPrimaryKey(Long id) {
        return smsMemberPriceMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SmsMemberPrice record) {
        return smsMemberPriceMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SmsMemberPrice record) {
        return smsMemberPriceMapper.updateByPrimaryKey(record);
    }

    @Override
    public int batchInsert(List<SmsMemberPrice> list) {
        return smsMemberPriceMapper.batchInsert(list);
    }

}
