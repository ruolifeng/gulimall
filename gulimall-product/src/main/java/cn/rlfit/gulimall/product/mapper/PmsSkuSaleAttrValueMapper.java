package cn.rlfit.gulimall.product.mapper;

import cn.rlfit.gulimall.product.domain.PmsSkuSaleAttrValue;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 18777
* @description 针对表【pms_sku_sale_attr_value(sku销售属性&值)】的数据库操作Mapper
* @createDate 2024-03-12 14:00:12
* @Entity cn.rlfit.gulimall.product.domain.PmsSkuSaleAttrValue
*/
@Mapper
public interface PmsSkuSaleAttrValueMapper {

    int deleteByPrimaryKey(Long id);

    int insert(PmsSkuSaleAttrValue record);

    int insertSelective(PmsSkuSaleAttrValue record);

    PmsSkuSaleAttrValue selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PmsSkuSaleAttrValue record);

    int updateByPrimaryKey(PmsSkuSaleAttrValue record);

}
