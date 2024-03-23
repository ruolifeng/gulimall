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
import java.util.*;

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
    public PageUtils<AttrVo> getInfo(Integer catId, Map<String, Object> pms, String attrType) {
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
        // TODO 不管分类id是不是0都是查询所有，所以这里有错误
        if (catId == 0) {
            attr = pmsAttrMapper.seleAll(page, size, key, Objects.equals(attrType, "base") ? 1 : 0);
        } else {
            PmsAttr pms2 = pmsAttrMapper.selectByPrimaryKey(Long.valueOf(catId), page, size, key, Objects.equals(attrType, "base") ? 1 : 0);
            attr = new ArrayList<>();
            attr.add(pms2);
        }
        attr.forEach(x -> {
            AttrRespVo vo = new AttrRespVo();
            BeanUtils.copyProperties(x, vo);
            String name = pmsCategoryMapper.selectByPrimaryKey(x.getCatelogId()).getName();
            vo.setCatelogName(name);
            if (pmsAttrAttrgroupRelationMapper.selectByPrimaryKey(x.getAttrId()).getAttrGroupId() != null) {

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
        PmsAttr pmsAttr = pmsAttrMapper.selectByPrimaryKey(id, null, null, null,null);
        // 获取分类信息
        if (pmsAttr.getCatelogId() != null) {
            PmsCategory pmsCategory = pmsCategoryMapper.selectByPrimaryKey(pmsAttr.getCatelogId());
            if (pmsCategory.getName() != null) {
                vo.setCatelogName(pmsCategory.getName());
            }
        }
        // 获取分组信息
        if (pmsAttrAttrgroupRelationMapper.selectByPrimaryKey(pmsAttr.getAttrId()).getAttrGroupId() != null) {

            PmsAttrGroup pmsAttrGroup = pmsAttrGroupMapper.selectByPrimaryKey(pmsAttrAttrgroupRelationMapper.selectByPrimaryKey(pmsAttr.getAttrId()).getAttrGroupId());
            if (pmsAttrGroup.getAttrGroupName() != null)
                vo.setGroupName(pmsAttrGroup.getAttrGroupName());
        }
        //组合
        BeanUtils.copyProperties(pmsAttr, vo);
        return vo;
    }

    @Override
    @Transactional
    public void update(AttrRespVo vo) {
        PmsAttr attr = new PmsAttr();
        BeanUtils.copyProperties(vo, attr);
        PmsAttrAttrgroupRelation relation = new PmsAttrAttrgroupRelation();
        BeanUtils.copyProperties(vo, relation);
        pmsAttrMapper.updateByPrimaryKey(attr);
        pmsAttrAttrgroupRelationMapper.updateByAttrId(vo.getAttrId(), vo.getAttrGroupId());
    }

    @Transactional
    @Override
    public void delete(Long[] ids) {
        // TODO当属性表和属性关系表中的字段数量不一致的时候可能会出现bug
        Arrays.stream(ids).distinct().forEach((x) -> {
            PmsAttr pmsAttr = pmsAttrMapper.selectByPrimaryKey(x, null, null, null,null);
            pmsAttrAttrgroupRelationMapper.deleteByPrimaryKey(x);
            pmsAttrMapper.deleteByPrimaryKey(x);

        });
    }
}
