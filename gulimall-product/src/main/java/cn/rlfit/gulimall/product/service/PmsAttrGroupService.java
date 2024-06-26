package cn.rlfit.gulimall.product.service;

import cn.rlfit.gulimall.product.domain.PageUtils;
import cn.rlfit.gulimall.product.domain.PmsAttrGroup;
import cn.rlfit.gulimall.product.vo.AttrGroupWithAttrsVo;

import java.util.List;
import java.util.Map;

/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 19/03/2024 11:10 AM
 */
public interface PmsAttrGroupService {
    PageUtils<PmsAttrGroup> queryPage(Map<String, Object> pms, Long catalogId);

    void save(PmsAttrGroup pmsAttrGroup);

    void delete(Long[] id);

    PmsAttrGroup getInfo(Long id);

    void update(PmsAttrGroup pmsAttrGroup);

    List<AttrGroupWithAttrsVo> getAttrGroupWithAttr(Long catelogId);
}
