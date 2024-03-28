package cn.rlfit.gulimall.product.service.impl;

import cn.rlfit.gulimall.product.domain.PmsAttrAttrgroupRelation;
import cn.rlfit.gulimall.product.mapper.PmsAttrAttrgroupRelationMapper;
import cn.rlfit.gulimall.product.service.PmsAttrRelationService;
import cn.rlfit.gulimall.product.vo.AttrGroupRelationVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 28/03/2024 4:58 PM
 */
@Service
public class PmsAttrRelationServiceImpl implements PmsAttrRelationService {
    @Resource
    PmsAttrAttrgroupRelationMapper pmsAttrAttrgroupRelationMapper;
    @Override
    public void addRelation(List<AttrGroupRelationVo> vo) {
        PmsAttrAttrgroupRelation pmsAttrAttrgroupRelation = new PmsAttrAttrgroupRelation();
        vo.stream().distinct().forEach(x->{
            pmsAttrAttrgroupRelation.setAttrGroupId(x.getAttrGroupId());
            pmsAttrAttrgroupRelation.setAttrId(x.getAttrId());
            pmsAttrAttrgroupRelationMapper.insertSelective(pmsAttrAttrgroupRelation);
        });
    }
}
