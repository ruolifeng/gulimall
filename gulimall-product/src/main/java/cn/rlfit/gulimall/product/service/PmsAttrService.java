package cn.rlfit.gulimall.product.service;

import cn.rlfit.gulimall.product.domain.PageUtils;
import cn.rlfit.gulimall.product.domain.PmsAttr;
import cn.rlfit.gulimall.product.vo.AttrRespVo;
import cn.rlfit.gulimall.product.vo.AttrVo;

import java.util.List;
import java.util.Map;

/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 23/03/2024 1:02 PM
 */
public interface PmsAttrService {
    void saveAttr(AttrVo vo);

    PageUtils<AttrVo> getInfo(Integer catId, Map<String,Object> pms, String attrType);

    AttrRespVo getOneInfo(Long id);

    void update(AttrRespVo vo);

    void delete(Long[] ids);

    List<PmsAttr> getRelationAttr(Long attrGroup);

    void deleteRelation(AttrRespVo[] attrRespVos);

    PageUtils<PmsAttr> getNoRelationAttr(Long attrGroup, Map<String, Object> pms);
}
