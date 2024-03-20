package cn.rlfit.gulimall.product.service.impl;

import cn.rlfit.gulimall.product.domain.PmsCategoryBrandRelation;
import cn.rlfit.gulimall.product.mapper.PmsCategoryBrandRelationMapper;
import cn.rlfit.gulimall.product.service.PmsCategoryBrandRelationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
    public List<PmsCategoryBrandRelation> getRelation(Long brandId) {
        return pmsCategoryBrandRelationMapper.getRelation(brandId);
    }

    @Override
    public void save(PmsCategoryBrandRelation relation) {
        pmsCategoryBrandRelationMapper.insertSelective(relation);
    }
}
