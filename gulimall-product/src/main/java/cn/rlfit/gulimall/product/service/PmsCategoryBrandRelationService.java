package cn.rlfit.gulimall.product.service;

import cn.rlfit.gulimall.product.domain.PmsCategoryBrandRelation;

import java.util.List;

/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 12/03/2024 3:29 PM
 */
public interface PmsCategoryBrandRelationService {

    List<PmsCategoryBrandRelation> getRelation(Long brandId);

    void save(PmsCategoryBrandRelation relation);
}
