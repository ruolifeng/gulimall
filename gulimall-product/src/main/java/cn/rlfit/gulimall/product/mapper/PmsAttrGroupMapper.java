package cn.rlfit.gulimall.product.mapper;

import cn.rlfit.gulimall.product.domain.PmsAttrGroup;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 18777
 * @description 针对表【pms_attr_group(属性分组)】的数据库操作Mapper
 * @createDate 2024-03-12 13:59:46
 * @Entity cn.rlfit.gulimall.product.domain.PmsAttrGroup
 */
@Mapper
public interface PmsAttrGroupMapper {

    int deleteByPrimaryKey(Long id);

    int insert(PmsAttrGroup record);

    int insertSelective(PmsAttrGroup record);

    PmsAttrGroup selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PmsAttrGroup record);

    int updateByPrimaryKey(PmsAttrGroup record);

    List<PmsAttrGroup> queryPage(@Param("key") String key, @Param("catalog") Long catalogId, @Param("page") Integer page, @Param("size") Integer size);

    Integer getCount();
}
