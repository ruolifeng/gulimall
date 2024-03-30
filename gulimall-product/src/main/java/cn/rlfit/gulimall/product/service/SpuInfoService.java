package cn.rlfit.gulimall.product.service;

import cn.rlfit.gulimall.product.domain.PmsProductAttrValue;
import cn.rlfit.gulimall.product.domain.PmsSpuInfo;
import cn.rlfit.gulimall.product.domain.PmsSpuInfoDesc;
import cn.rlfit.gulimall.product.vo.SpuSaveVo;

import java.util.List;

/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 30/03/2024 2:14 PM
 */
public interface SpuInfoService {
    void saveSpuInfo(SpuSaveVo vo);

    void saveBaseInfo(PmsSpuInfo pmsSpuInfo);

    void saveSpuInfoDesc(PmsSpuInfoDesc pmsSpuInfoDesc);

    void saveImages(Long id, List<String> images);

    void saveProductAttrValue(List<PmsProductAttrValue> collect);
}
