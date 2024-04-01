package cn.rlfit.gulimall.product.mapper;

import cn.rlfit.gulimall.product.domain.PmsSkuInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

/**
* @author 18777
* @description 针对表【pms_sku_info(sku信息)】的数据库操作Mapper
* @createDate 2024-03-12 14:00:09
* @Entity cn.rlfit.gulimall.product.domain.PmsSkuInfo
*/
@Mapper
public interface PmsSkuInfoMapper {

    int deleteByPrimaryKey(Long id);

    int insert(PmsSkuInfo record);

    int insertSelective(PmsSkuInfo record);

    PmsSkuInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PmsSkuInfo record);

    int updateByPrimaryKey(PmsSkuInfo record);

    List<PmsSkuInfo> getSkuInfoList(@Param("page") Integer page, @Param("size") Integer size, @Param("key") String key, @Param("max") BigDecimal max, @Param("min") BigDecimal min, @Param("brandId") Long brandId, @Param("catelogId") Long catelogId);

    Integer getCount(@Param("key") String key, @Param("max") BigDecimal max, @Param("min") BigDecimal min, @Param("brandId") Long brandId, @Param("catelogId") Long catelogId);
}
