package cn.rlfit.gulimall.product.service;

import cn.rlfit.gulimall.product.domain.PmsSkuInfo;
import cn.rlfit.gulimall.utils.resp.Page;

import java.util.List;
import java.util.Map;

/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 01/04/2024 9:32 AM
 */
public interface PmsSkuInfoService {
    Page<List<PmsSkuInfo>> getSkuInfoList(Map<String, Object> params);
}
