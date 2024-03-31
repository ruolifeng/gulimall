package cn.rlfit.gulimallcoupon.service.impl;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import cn.rlfit.gulimallcoupon.domain.SmsSeckillPromotion;
import cn.rlfit.gulimallcoupon.mapper.SmsSeckillPromotionMapper;
import cn.rlfit.gulimallcoupon.service.SmsSeckillPromotionService;
/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 31/03/2024 1:10 PM
 */
@Service
public class SmsSeckillPromotionServiceImpl implements SmsSeckillPromotionService{

    @Autowired
    private SmsSeckillPromotionMapper smsSeckillPromotionMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return smsSeckillPromotionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SmsSeckillPromotion record) {
        return smsSeckillPromotionMapper.insert(record);
    }

    @Override
    public int insertSelective(SmsSeckillPromotion record) {
        return smsSeckillPromotionMapper.insertSelective(record);
    }

    @Override
    public SmsSeckillPromotion selectByPrimaryKey(Long id) {
        return smsSeckillPromotionMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SmsSeckillPromotion record) {
        return smsSeckillPromotionMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SmsSeckillPromotion record) {
        return smsSeckillPromotionMapper.updateByPrimaryKey(record);
    }

    @Override
    public int batchInsert(List<SmsSeckillPromotion> list) {
        return smsSeckillPromotionMapper.batchInsert(list);
    }

}
