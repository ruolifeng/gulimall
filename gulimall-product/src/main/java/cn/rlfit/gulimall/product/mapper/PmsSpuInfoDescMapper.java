package cn.rlfit.gulimall.product.mapper;

import cn.rlfit.gulimall.product.domain.PmsSpuInfoDesc;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 18777
* @description 针对表【pms_spu_info_desc(spu信息介绍)】的数据库操作Mapper
* @createDate 2024-03-12 14:00:30
* @Entity cn.rlfit.gulimall.product.domain.PmsSpuInfoDesc
*/
@Mapper
public interface PmsSpuInfoDescMapper {

    int deleteByPrimaryKey(Long id);

    int insert(PmsSpuInfoDesc record);

    int insertSelective(PmsSpuInfoDesc record);

    PmsSpuInfoDesc selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PmsSpuInfoDesc record);

    int updateByPrimaryKey(PmsSpuInfoDesc record);

}
