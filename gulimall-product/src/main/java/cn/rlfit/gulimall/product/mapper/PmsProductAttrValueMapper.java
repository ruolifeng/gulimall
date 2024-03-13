package cn.rlfit.gulimall.product.mapper;

import cn.rlfit.gulimall.product.domain.PmsProductAttrValue;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 18777
* @description 针对表【pms_product_attr_value(spu属性值)】的数据库操作Mapper
* @createDate 2024-03-12 14:00:03
* @Entity cn.rlfit.gulimall.product.domain.PmsProductAttrValue
*/
@Mapper
public interface PmsProductAttrValueMapper {

    int deleteByPrimaryKey(Long id);

    int insert(PmsProductAttrValue record);

    int insertSelective(PmsProductAttrValue record);

    PmsProductAttrValue selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PmsProductAttrValue record);

    int updateByPrimaryKey(PmsProductAttrValue record);

}
