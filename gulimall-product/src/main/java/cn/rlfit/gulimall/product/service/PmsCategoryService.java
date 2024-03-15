package cn.rlfit.gulimall.product.service;

import cn.rlfit.gulimall.product.domain.PmsCategory;

import java.util.List;

/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 14/03/2024 2:29 PM
 */
public interface PmsCategoryService {
    List<PmsCategory> getAllCategoryToTree();

    void deleteMenusByCatIds(List<Long> list);
}
