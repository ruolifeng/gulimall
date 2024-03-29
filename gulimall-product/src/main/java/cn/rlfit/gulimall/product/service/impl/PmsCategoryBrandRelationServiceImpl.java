package cn.rlfit.gulimall.product.service.impl;

import cn.rlfit.gulimall.product.domain.PmsBrand;
import cn.rlfit.gulimall.product.domain.PmsCategoryBrandRelation;
import cn.rlfit.gulimall.product.mapper.PmsBrandMapper;
import cn.rlfit.gulimall.product.mapper.PmsCategoryBrandRelationMapper;
import cn.rlfit.gulimall.product.service.PmsCategoryBrandRelationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 12/03/2024 3:36 PM
 */
@Service
public class PmsCategoryBrandRelationServiceImpl implements PmsCategoryBrandRelationService {
    @Resource
    PmsCategoryBrandRelationMapper pmsCategoryBrandRelationMapper;
    @Resource
    PmsBrandMapper pmsBrandMapper;

    @Override
    public List<PmsCategoryBrandRelation> getRelation(Long brandId) {
        return pmsCategoryBrandRelationMapper.getRelation(brandId);
    }

    @Override
    public void save(PmsCategoryBrandRelation relation) {
        pmsCategoryBrandRelationMapper.insertSelective(relation);
    }

    @Override
    public void delete(Long[] ids) {
        Arrays.stream(ids).distinct().forEach(x->pmsCategoryBrandRelationMapper.deleteByPrimaryKey(x));
    }

    @Override
    public List<PmsBrand> getBrandsByCatId(Long catId) {
       List<PmsCategoryBrandRelation> pmsCategoryBrandRelations = pmsCategoryBrandRelationMapper.getBrandsByCatId(catId);
        return pmsCategoryBrandRelations.stream().map(item -> {
            Long brandId = item.getBrandId();
            return pmsBrandMapper.selectByPrimaryKey(brandId);
        }).collect(Collectors.toList());
    }
}
