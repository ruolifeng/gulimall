package cn.rlfit.gulimall.product.service;

import cn.rlfit.gulimall.product.domain.PageUtils;
import cn.rlfit.gulimall.product.domain.PmsAttrGroup;

import java.util.Map;

/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 19/03/2024 11:10 AM
 */
public interface PmsAttrGroupService {
    PageUtils<PmsAttrGroup> queryPage(Map<String, Object> pms, Long catalogId);
}
