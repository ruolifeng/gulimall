package cn.rlfit.gulimallcoupon.service.impl;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import cn.rlfit.gulimallcoupon.domain.SmsSeckillSkuRelation;
import cn.rlfit.gulimallcoupon.mapper.SmsSeckillSkuRelationMapper;
import cn.rlfit.gulimallcoupon.service.SmsSeckillSkuRelationService;
/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 31/03/2024 1:15 PM
 */
@Service
public class SmsSeckillSkuRelationServiceImpl implements SmsSeckillSkuRelationService{

    @Autowired
    private SmsSeckillSkuRelationMapper smsSeckillSkuRelationMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return smsSeckillSkuRelationMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SmsSeckillSkuRelation record) {
        return smsSeckillSkuRelationMapper.insert(record);
    }

    @Override
    public int insertSelective(SmsSeckillSkuRelation record) {
        return smsSeckillSkuRelationMapper.insertSelective(record);
    }

    @Override
    public SmsSeckillSkuRelation selectByPrimaryKey(Long id) {
        return smsSeckillSkuRelationMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SmsSeckillSkuRelation record) {
        return smsSeckillSkuRelationMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SmsSeckillSkuRelation record) {
        return smsSeckillSkuRelationMapper.updateByPrimaryKey(record);
    }

    @Override
    public int batchInsert(List<SmsSeckillSkuRelation> list) {
        return smsSeckillSkuRelationMapper.batchInsert(list);
    }

}
