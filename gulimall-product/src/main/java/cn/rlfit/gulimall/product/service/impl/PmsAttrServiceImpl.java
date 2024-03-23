package cn.rlfit.gulimall.product.service.impl;

import cn.rlfit.gulimall.product.domain.*;
import cn.rlfit.gulimall.product.mapper.PmsAttrAttrgroupRelationMapper;
import cn.rlfit.gulimall.product.mapper.PmsAttrGroupMapper;
import cn.rlfit.gulimall.product.mapper.PmsAttrMapper;
import cn.rlfit.gulimall.product.mapper.PmsCategoryMapper;
import cn.rlfit.gulimall.product.service.PmsAttrService;
import cn.rlfit.gulimall.product.vo.AttrRespVo;
import cn.rlfit.gulimall.product.vo.AttrVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    @Resource
    PmsAttrGroupMapper pmsAttrGroupMapper;
    @Resource
    PmsCategoryMapper pmsCategoryMapper;

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
    public PageUtils<AttrVo> getInfo(Integer catId, Map<String, Object> pms) {
        PageUtils<AttrVo> pageUtils = new PageUtils<>();
        Integer page = null;
        Integer size = null;
        String key = null;
        if (pms.get("page") != null)
            page = Integer.parseInt((String) pms.get("page"));
        if (pms.get("limit") != null)
            size = Integer.parseInt((String) pms.get("limit"));
        if (pms.get("key") != null)
            key = (String) pms.get("key");
        List<PmsAttr> attr = null;
        List<AttrVo> attrVos = new ArrayList<>();
        if (catId == 0) {
            attr = pmsAttrMapper.seleAll(page, size, key);
        } else {
            PmsAttr pms2 = pmsAttrMapper.selectByPrimaryKey(Long.valueOf(catId), page, size, key);
            attr = new ArrayList<>();
            attr.add(pms2);
        }
        attr.forEach(x -> {
            AttrRespVo vo = new AttrRespVo();
            BeanUtils.copyProperties(x, vo);
            String name = pmsCategoryMapper.selectByPrimaryKey(x.getCatelogId()).getName();
            vo.setCatelogName(name);
            if (pmsAttrAttrgroupRelationMapper.selectByPrimaryKey(x.getAttrId()).getAttrGroupId() != null){

                PmsAttrGroup pmsAttrGroup = pmsAttrGroupMapper.selectByPrimaryKey(pmsAttrAttrgroupRelationMapper.selectByPrimaryKey(x.getAttrId()).getAttrGroupId());
                String attrGroupName = pmsAttrGroup.getAttrGroupName();
                vo.setGroupName(attrGroupName);
            }
            attrVos.add(vo);
        });
        int count = pmsAttrMapper.getCount();
        pageUtils.setData(attrVos);
        pageUtils.setPageSize(size);
        pageUtils.setCurrentPage(page);
        pageUtils.setTotalCount(count);
        return pageUtils;
    }

    @Override
    public AttrRespVo getOneInfo(Long id) {
        AttrRespVo vo = new AttrRespVo();
        // 获取基本属性信息
        PmsAttr pmsAttr = pmsAttrMapper.selectByPrimaryKey(id, null, null, null);
        // 获取分类信息
        PmsCategory pmsCategory = pmsCategoryMapper.selectByPrimaryKey(pmsAttr.getCatelogId());
        // 获取分组信息
        PmsAttrGroup pmsAttrGroup = pmsAttrGroupMapper.selectByPrimaryKey(pmsAttrAttrgroupRelationMapper.selectByPrimaryKey(pmsAttr.getAttrId()).getAttrGroupId());
        //组合
        BeanUtils.copyProperties(pmsAttr, vo);
        vo.setGroupName(pmsAttrGroup.getAttrGroupName());
        vo.setCatelogName(pmsCategory.getName());
        return vo;
    }
}