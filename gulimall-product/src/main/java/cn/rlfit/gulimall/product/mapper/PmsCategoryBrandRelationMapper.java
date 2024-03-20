package cn.rlfit.gulimall.product.mapper;

import cn.rlfit.gulimall.product.domain.PmsCategoryBrandRelation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author 18777
* @description 针对表【pms_category_brand_relation(品牌分类关联)】的数据库操作Mapper
* @createDate 2024-03-12 13:59:57
* @Entity cn.rlfit.gulimall.product.domain.PmsCategoryBrandRelation
*/
@Mapper
public interface PmsCategoryBrandRelationMapper {

    int deleteByPrimaryKey(Long id);

    int insert(PmsCategoryBrandRelation record);

    int insertSelective(PmsCategoryBrandRelation record);

    PmsCategoryBrandRelation selectByPrimaryKey(@Param("id") Long id);

    int updateByPrimaryKeySelective(PmsCategoryBrandRelation record);

    int updateByPrimaryKey(PmsCategoryBrandRelation record);

    List<PmsCategoryBrandRelation> getRelation(@Param("brandId") Long brandId);
}
