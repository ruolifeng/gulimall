package cn.rlfit.gulimall.product.mapper;

import cn.rlfit.gulimall.product.domain.PmsSkuImages;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 18777
* @description 针对表【pms_sku_images(sku图片)】的数据库操作Mapper
* @createDate 2024-03-12 14:00:07
* @Entity cn.rlfit.gulimall.product.domain.PmsSkuImages
*/
@Mapper
public interface PmsSkuImagesMapper {

    int deleteByPrimaryKey(Long id);

    int insert(PmsSkuImages record);

    int insertSelective(PmsSkuImages record);

    PmsSkuImages selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PmsSkuImages record);

    int updateByPrimaryKey(PmsSkuImages record);

}
