package cn.rlfit.gulimall.product.mapper;

import cn.rlfit.gulimall.product.domain.PmsSpuInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 18777
 * @description 针对表【pms_spu_info(spu信息)】的数据库操作Mapper
 * @createDate 2024-03-12 14:00:27
 * @Entity cn.rlfit.gulimall.product.domain.PmsSpuInfo
 */
@Mapper
public interface PmsSpuInfoMapper {

    int deleteByPrimaryKey(Long id);

    int insert(PmsSpuInfo record);

    int insertSelective(PmsSpuInfo record);

    PmsSpuInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PmsSpuInfo record);

    int updateByPrimaryKey(PmsSpuInfo record);

//    void saveBaseInfo(PmsSpuInfo pmsSpuInfo);

    List<PmsSpuInfo> getAllByCondition(@Param("page") Integer page, @Param("size") Integer size, @Param("key") String key, @Param("brandId") Long brandId, @Param("catelogId") Long catelogId, @Param("status") Integer status);

    Integer getCount(@Param("page") Integer page, @Param("size") Integer size, @Param("key") String key, @Param("brandId") Long brandId, @Param("catelogId") Long catelogId, @Param("status") Integer status);
}
