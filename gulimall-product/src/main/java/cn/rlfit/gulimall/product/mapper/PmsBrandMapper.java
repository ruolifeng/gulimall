package cn.rlfit.gulimall.product.mapper;

import cn.rlfit.gulimall.product.domain.PmsBrand;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 18777
* @description 针对表【pms_brand(品牌)】的数据库操作Mapper
* @createDate 2024-03-12 13:59:49
* @Entity cn.rlfit.gulimall.product.domain.PmsBrand
*/
@Mapper
public interface PmsBrandMapper {

    int deleteByPrimaryKey(Long id);

    int insert(PmsBrand record);

    int insertSelective(PmsBrand record);

    PmsBrand selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PmsBrand record);

    int updateByPrimaryKey(PmsBrand record);

}
