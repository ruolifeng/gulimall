package cn.rlfit.gulimall.product.service.impl;

import cn.rlfit.gulimall.product.domain.PmsCategoryBrandRelation;
import cn.rlfit.gulimall.product.mapper.PmsCategoryBrandRelationMapper;
import cn.rlfit.gulimall.product.service.PmsCategoryBrandRelationService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 12/03/2024 3:36 PM
 */
@Service
public class PmsCategoryBrandRelationServiceImpl implements PmsCategoryBrandRelationService {
    @Resource
    PmsCategoryBrandRelationMapper pmsCategoryBrandRelationMapper;
    @Override
    public PmsCategoryBrandRelation selectByPrimaryKey(int id) {
        PmsCategoryBrandRelation pmsCategoryBrandRelation = pmsCategoryBrandRelationMapper.selectByPrimaryKey((long) id);
        return pmsCategoryBrandRelation;
    }
}
