package cn.rlfit.gulimallcoupon.service.impl;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import cn.rlfit.gulimallcoupon.domain.SmsCouponSpuRelation;
import cn.rlfit.gulimallcoupon.mapper.SmsCouponSpuRelationMapper;
import cn.rlfit.gulimallcoupon.service.SmsCouponSpuRelationService;
/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 31/03/2024 1:10 PM
 */
@Service
public class SmsCouponSpuRelationServiceImpl implements SmsCouponSpuRelationService{

    @Autowired
    private SmsCouponSpuRelationMapper smsCouponSpuRelationMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return smsCouponSpuRelationMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SmsCouponSpuRelation record) {
        return smsCouponSpuRelationMapper.insert(record);
    }

    @Override
    public int insertSelective(SmsCouponSpuRelation record) {
        return smsCouponSpuRelationMapper.insertSelective(record);
    }

    @Override
    public SmsCouponSpuRelation selectByPrimaryKey(Long id) {
        return smsCouponSpuRelationMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SmsCouponSpuRelation record) {
        return smsCouponSpuRelationMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SmsCouponSpuRelation record) {
        return smsCouponSpuRelationMapper.updateByPrimaryKey(record);
    }

    @Override
    public int batchInsert(List<SmsCouponSpuRelation> list) {
        return smsCouponSpuRelationMapper.batchInsert(list);
    }

}
