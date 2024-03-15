package cn.rlfit.gulimall.product.mapper;

import cn.rlfit.gulimall.product.domain.PmsCategory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author 18777
* @description 针对表【pms_category(商品三级分类)】的数据库操作Mapper
* @createDate 2024-03-12 13:59:53
* @Entity cn.rlfit.gulimall.product.domain.PmsCategory
*/
@Mapper
public interface PmsCategoryMapper {

    int deleteByPrimaryKey(Long id);

    int insert(PmsCategory record);

    int insertSelective(PmsCategory record);

    PmsCategory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PmsCategory record);

    int updateByPrimaryKey(PmsCategory record);

    List<PmsCategory> getAllCategory();

    void deleteMenusByCatIds(Long catId);
}
