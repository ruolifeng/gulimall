package cn.rlfit.gulimall.product.service.impl;

import cn.rlfit.gulimall.product.domain.PmsAttr;
import cn.rlfit.gulimall.product.domain.PmsAttrAttrgroupRelation;
import cn.rlfit.gulimall.product.mapper.PmsAttrAttrgroupRelationMapper;
import cn.rlfit.gulimall.product.mapper.PmsAttrMapper;
import cn.rlfit.gulimall.product.service.PmsAttrService;
import cn.rlfit.gulimall.product.vo.AttrVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 23/03/2024 1:02 PM
 */
@Service
public class PmsAttrServiceImpl implements PmsAttrService {
    @Resource
    PmsAttrMapper pmsAttrMapper;
    @Resource
    PmsAttrAttrgroupRelationMapper pmsAttrAttrgroupRelationMapper;

    @Override
    @Transactional
    public void saveAttr(AttrVo vo) {
        PmsAttr pmsAttrGroup = new PmsAttr();
        // 先保存属性信息，再将属性的分组信息保存
        BeanUtils.copyProperties(vo, pmsAttrGroup);
        System.out.println(pmsAttrGroup);
        int i = pmsAttrMapper.insertSelective(pmsAttrGroup);
        // 保存关联关系
        PmsAttrAttrgroupRelation pmsAttrAttrgroupRelation = new PmsAttrAttrgroupRelation();
        if (vo.getAttrGroupId() != null) pmsAttrAttrgroupRelation.setAttrGroupId(vo.getAttrGroupId());
        pmsAttrAttrgroupRelation.setAttrId((long) i);
        pmsAttrAttrgroupRelationMapper.insertSelective(pmsAttrAttrgroupRelation);
    }

    @Override
    public List<AttrVo> getInfo(Integer catId) {
        // TODO 所属分组和分类，分页查询，页面大小还没有查询
        List<PmsAttr> attr = null;
        List<AttrVo> attrVos = new ArrayList<>();
        AttrVo vo = new AttrVo();
        if (catId == 0) {
            attr = pmsAttrMapper.seleAll();
        } else {
            PmsAttr pms = pmsAttrMapper.selectByPrimaryKey(Long.valueOf(catId));
            attr = new ArrayList<>();
            attr.add(pms);
        }
        attr.forEach(x -> {
            BeanUtils.copyProperties(x, vo);
            attrVos.add(vo);
        });
        return attrVos;
    }
}
