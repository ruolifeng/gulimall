package cn.rlfit.gulimall.product.service;

import cn.rlfit.gulimall.product.domain.*;
import cn.rlfit.gulimall.product.vo.SpuSaveVo;
import cn.rlfit.gulimall.utils.resp.Page;

import java.util.List;
import java.util.Map;

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

    void saveSkuInfo(PmsSkuInfo pmsSkuInfo);

    void saveSkuImages(List<PmsSkuImages> collect1);

    void saveSkuSaleAttrValue(List<PmsSkuSaleAttrValue> collect2);

    Page<List<PmsSpuInfo>> getAllByCondition(Map<String,Object> pms);
}
