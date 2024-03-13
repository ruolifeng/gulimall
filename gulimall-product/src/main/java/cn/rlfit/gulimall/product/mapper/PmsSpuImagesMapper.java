package cn.rlfit.gulimall.product.mapper;

import cn.rlfit.gulimall.product.domain.PmsSpuImages;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 18777
* @description 针对表【pms_spu_images(spu图片)】的数据库操作Mapper
* @createDate 2024-03-12 14:00:18
* @Entity cn.rlfit.gulimall.product.domain.PmsSpuImages
*/
@Mapper
public interface PmsSpuImagesMapper {

    int deleteByPrimaryKey(Long id);

    int insert(PmsSpuImages record);

    int insertSelective(PmsSpuImages record);

    PmsSpuImages selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PmsSpuImages record);

    int updateByPrimaryKey(PmsSpuImages record);

}
