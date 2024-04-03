package cn.rlfit.gulimall.product.service.impl;

import cn.rlfit.gulimall.product.domain.PmsSkuInfo;
import cn.rlfit.gulimall.product.mapper.PmsSkuInfoMapper;
import cn.rlfit.gulimall.product.service.PmsSkuInfoService;
import cn.rlfit.gulimall.utils.resp.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 01/04/2024 9:32 AM
 */
@Service
public class PmsSkuInfoServiceImpl implements PmsSkuInfoService {
    @Resource
    private PmsSkuInfoMapper pmsSkuInfoMapper;

    @Override
    public Page<List<PmsSkuInfo>> getSkuInfoList(Map<String, Object> pms) {
        Integer page = null;
        Integer size = null;
        String key = null;
        BigDecimal max = null;
        BigDecimal min = null;
        Long brandld = null;
        Long catelogId = null;
        if (pms.get("page") != null)
            page = Integer.parseInt((String) pms.get("page"));
        if (pms.get("limit") != null)
            size = Integer.parseInt((String) pms.get("limit"));
        if (pms.get("key") != null)
            key = (String) pms.get("key");
        if (!Objects.isNull(pms.get("max")) && ! "0".equalsIgnoreCase((String) pms.get("max")))
            max = new BigDecimal(String.valueOf(pms.get("max")));
        if (!Objects.isNull(pms.get("min")))
            min = new BigDecimal(String.valueOf(pms.get("min")));
        if (!Objects.isNull(pms.get("brandId")))
            brandld = Long.parseLong((String) pms.get("brandId"));
        if (!Objects.isNull(pms.get("catelogId")))
            catelogId = Long.valueOf((String) pms.get("catelogId"));
        List<PmsSkuInfo> pmsSkuInfos = pmsSkuInfoMapper.getSkuInfoList(page, size, key, max, min, brandld, catelogId);
        Integer count = pmsSkuInfoMapper.getCount(key, max, min, brandld, catelogId);
        Page<List<PmsSkuInfo>> pageData = new Page<>();
        pageData.setTotalCount(count);
        pageData.setCurrentPage(page);
        pageData.setData(pmsSkuInfos);
        if (pms.get("limit") != null)
            pageData.setTotalPage(count / size);
        return pageData;
    }

    @Override
    public PmsSkuInfo getSkuInfoById(Long skuId) {
        return pmsSkuInfoMapper.selectByPrimaryKey(skuId);
    }
}
