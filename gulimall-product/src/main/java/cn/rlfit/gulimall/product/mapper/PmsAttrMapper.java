package cn.rlfit.gulimall.product.mapper;

import cn.rlfit.gulimall.product.domain.PmsAttr;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 18777
* @description 针对表【pms_attr(商品属性)】的数据库操作Mapper
* @createDate 2024-03-12 13:53:04
* @Entity cn.rlfit.gulimall.product.domain.PmsAttr
*/
@Mapper
public interface PmsAttrMapper {

    int deleteByPrimaryKey(Long id);

    int insert(PmsAttr record);

    int insertSelective(PmsAttr record);

    PmsAttr selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PmsAttr record);

    int updateByPrimaryKey(PmsAttr record);

}
