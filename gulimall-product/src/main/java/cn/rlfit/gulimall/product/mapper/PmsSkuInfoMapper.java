package cn.rlfit.gulimall.product.mapper;

import cn.rlfit.gulimall.product.domain.PmsSkuInfo;
import org.apache.ibatis.annotations.Mapper;

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

}
