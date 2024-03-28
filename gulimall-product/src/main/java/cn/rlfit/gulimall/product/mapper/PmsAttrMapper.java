package cn.rlfit.gulimall.product.mapper;

import cn.rlfit.gulimall.product.domain.PmsAttr;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    PmsAttr selectByPrimaryKey(@Param("id") Long id, @Param("page") Integer page, @Param("size") Integer size, @Param("key") String key, @Param("type") Integer type);

    int updateByPrimaryKeySelective(PmsAttr record);

    int updateByPrimaryKey(PmsAttr record);

    List<PmsAttr> seleAll(@Param("cateId") Long id, @Param("page") Integer page, @Param("size") Integer size, @Param("key") String key, @Param("attrType") Integer attrType);

    int getCount();


    List<PmsAttr> selectAllNotRelation(@Param("ids") List<Long> id, @Param("attrGroupId") Long attrGroupId, @Param("page") Integer page, @Param("size") Integer size, @Param("key") String key);

    Integer selectCount(@Param("attrGroupId") Long attrGroupId);
}
