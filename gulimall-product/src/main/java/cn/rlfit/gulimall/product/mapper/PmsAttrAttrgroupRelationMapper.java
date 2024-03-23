package cn.rlfit.gulimall.product.mapper;

import cn.rlfit.gulimall.product.domain.PmsAttrAttrgroupRelation;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 18777
* @description 针对表【pms_attr_attrgroup_relation(属性&属性分组关联)】的数据库操作Mapper
* @createDate 2024-03-12 13:59:41
* @Entity cn.rlfit.gulimall.product.domain.PmsAttrAttrgroupRelation
*/
@Mapper
public interface PmsAttrAttrgroupRelationMapper {

    int deleteByPrimaryKey(Long id);

    int insert(PmsAttrAttrgroupRelation record);

    int insertSelective(PmsAttrAttrgroupRelation record);

    PmsAttrAttrgroupRelation selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PmsAttrAttrgroupRelation record);

    int updateByPrimaryKey(PmsAttrAttrgroupRelation record);

    void updateByAttrId(Long attrId,Long getAttrGroupId);
}
