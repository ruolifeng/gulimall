package cn.rlfit.gulimall.product.service;

import cn.rlfit.gulimall.product.domain.PmsCategoryBrandRelation;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 12/03/2024 3:29 PM
 */
public interface PmsCategoryBrandRelationService {

    PmsCategoryBrandRelation selectByPrimaryKey(int id);
}
