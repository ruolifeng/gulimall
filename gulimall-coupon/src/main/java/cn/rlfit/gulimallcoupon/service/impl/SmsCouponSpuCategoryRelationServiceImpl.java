package cn.rlfit.gulimallcoupon.service.impl;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import cn.rlfit.gulimallcoupon.domain.SmsCouponSpuCategoryRelation;
import cn.rlfit.gulimallcoupon.mapper.SmsCouponSpuCategoryRelationMapper;
import cn.rlfit.gulimallcoupon.service.SmsCouponSpuCategoryRelationService;
/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 31/03/2024 1:10 PM
 */
@Service
public class SmsCouponSpuCategoryRelationServiceImpl implements SmsCouponSpuCategoryRelationService{

    @Autowired
    private SmsCouponSpuCategoryRelationMapper smsCouponSpuCategoryRelationMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return smsCouponSpuCategoryRelationMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SmsCouponSpuCategoryRelation record) {
        return smsCouponSpuCategoryRelationMapper.insert(record);
    }

    @Override
    public int insertSelective(SmsCouponSpuCategoryRelation record) {
        return smsCouponSpuCategoryRelationMapper.insertSelective(record);
    }

    @Override
    public SmsCouponSpuCategoryRelation selectByPrimaryKey(Long id) {
        return smsCouponSpuCategoryRelationMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SmsCouponSpuCategoryRelation record) {
        return smsCouponSpuCategoryRelationMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SmsCouponSpuCategoryRelation record) {
        return smsCouponSpuCategoryRelationMapper.updateByPrimaryKey(record);
    }

    @Override
    public int batchInsert(List<SmsCouponSpuCategoryRelation> list) {
        return smsCouponSpuCategoryRelationMapper.batchInsert(list);
    }

}
