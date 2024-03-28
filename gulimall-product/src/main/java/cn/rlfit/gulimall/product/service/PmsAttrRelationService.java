package cn.rlfit.gulimall.product.service;

import cn.rlfit.gulimall.product.vo.AttrGroupRelationVo;

import java.util.List;

/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 28/03/2024 4:57 PM
 */
public interface PmsAttrRelationService {
    void addRelation(List<AttrGroupRelationVo> vo);
}
