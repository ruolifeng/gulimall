package cn.rlfit.gulimall.product.service.impl;

import cn.rlfit.gulimall.product.domain.*;
import cn.rlfit.gulimall.product.feign.CouponFeignService;
import cn.rlfit.gulimall.product.mapper.*;
import cn.rlfit.gulimall.product.service.SpuInfoService;
import cn.rlfit.gulimall.product.vo.*;
import cn.rlfit.gulimall.to.SkuReduction;
import cn.rlfit.gulimall.to.SpuBoundsTo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * TODO 高级部分完善更加复杂的失败逻辑
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 30/03/2024 2:14 PM
 */
@Service
public class SpuInfoServiceImpl implements SpuInfoService {
    @Autowired
    PmsSpuInfoMapper pmsSpuInfoMapper;
    @Autowired
    PmsSpuInfoDescMapper pmsSpuInfoDescMapper;
    @Autowired
    PmsSpuImagesMapper pmsSpuImagesMapper;
    @Autowired
    PmsAttrMapper pmsAttrMapper;
    @Autowired
    PmsProductAttrValueMapper pmsProductAttrValueMapper;
    @Autowired
    PmsSkuInfoMapper pmsSkuInfoMapper;
    @Autowired
    PmsSkuImagesMapper pmsSkuImagesMapper;
    @Autowired
    PmsSkuSaleAttrValueMapper pmsSkuSaleAttrValueMapper;
    @Resource
    CouponFeignService couponFeignService;

    @Override
    @Transactional
    public void saveSpuInfo(SpuSaveVo vo) {
        // 保存spu的基本信息
        PmsSpuInfo pmsSpuInfo = new PmsSpuInfo();
        BeanUtils.copyProperties(vo, pmsSpuInfo);
        pmsSpuInfo.setCreateTime(new Date());
        pmsSpuInfo.setUpdateTime(new Date());
        this.saveBaseInfo(pmsSpuInfo);
        // 保存描述
        List<String> decript = vo.getDecript();
        PmsSpuInfoDesc pmsSpuInfoDesc = new PmsSpuInfoDesc();
        pmsSpuInfoDesc.setSpuId(pmsSpuInfo.getId());
        pmsSpuInfoDesc.setDecript(String.join(",", decript));
        this.saveSpuInfoDesc(pmsSpuInfoDesc);
        // 保存图片集合
        List<String> images = vo.getImages();
        this.saveImages(pmsSpuInfo.getId(), images);
        // 保存基本属性（规格参数）
        List<BaseAttrs> baseAttrs = vo.getBaseAttrs();
        List<PmsProductAttrValue> collect = baseAttrs.stream().map(attr -> {
            PmsProductAttrValue pmsProductAttrValue = new PmsProductAttrValue();
            pmsProductAttrValue.setAttrId(attr.getAttrId());
            PmsAttr pmsAttr = pmsAttrMapper.selectByPrimaryKey(attr.getAttrId(), null, null, null, null);
            pmsProductAttrValue.setAttrName(pmsAttr.getAttrName());
            pmsProductAttrValue.setAttrValue(attr.getAttrValues());
            pmsProductAttrValue.setQuickShow(attr.getShowDesc());
            pmsProductAttrValue.setSpuId(pmsSpuInfo.getId());
            return pmsProductAttrValue;
        }).collect(Collectors.toList());
        this.saveProductAttrValue(collect);
        Bounds bounds = vo.getBounds();
        SpuBoundsTo spuBoundsTo = new SpuBoundsTo();
        BeanUtils.copyProperties(bounds, spuBoundsTo);
        spuBoundsTo.setSpuId(pmsSpuInfo.getId());
        couponFeignService.saveSpuBounds(spuBoundsTo);

        // 保存积分信息
        // 保存所有sku信息
        List<Skus> skus = vo.getSkus();
        if (skus != null && !skus.isEmpty()) {
            skus.forEach(sku -> {
                String defaultImage = "";
                for (Images image : sku.getImages()) {
                    if (image.getDefaultImg() == 1) {
                        defaultImage = image.getImgUrl();
                    }
                }
                // 保存sku的基本信息
                PmsSkuInfo pmsSkuInfo = new PmsSkuInfo();
                BeanUtils.copyProperties(sku, pmsSkuInfo);
                pmsSkuInfo.setBrandId(pmsSpuInfo.getBrandId());
                pmsSkuInfo.setCatalogId(pmsSpuInfo.getCatalogId());
                pmsSkuInfo.setSaleCount(0L);
                pmsSkuInfo.setSpuId(pmsSpuInfo.getId());
                pmsSkuInfo.setSkuDefaultImg(defaultImage);
                // 主键id可能获取不到
                Long skuId = pmsSkuInfo.getSkuId();
                this.saveSkuInfo(pmsSkuInfo);
                List<Images> images1 = sku.getImages();
                // 保存sku的图片信息
                List<PmsSkuImages> collect1 = images1.stream().map(img -> {
                    PmsSkuImages pmsSkuImages = new PmsSkuImages();
                    pmsSkuImages.setSkuId(skuId);
                    pmsSkuImages.setImgUrl(img.getImgUrl());
                    pmsSkuImages.setDefaultImg(img.getDefaultImg());
                    return pmsSkuImages;
                }).filter(item -> !item.getImgUrl().isEmpty()).collect(Collectors.toList());
                this.saveSkuImages(collect1);
                List<Attr> attr = sku.getAttr();
                List<PmsSkuSaleAttrValue> collect2 = attr.stream().map(a -> {
                    PmsSkuSaleAttrValue pmsSkuSaleAttrValue = new PmsSkuSaleAttrValue();
                    BeanUtils.copyProperties(a, pmsSkuSaleAttrValue);
                    pmsSkuSaleAttrValue.setSkuId(skuId);
                    return pmsSkuSaleAttrValue;
                }).collect(Collectors.toList());
                this.saveSkuSaleAttrValue(collect2);
                // 保存sku的销售属性值
                // 保存sku的优惠信息（跨库保存）
                SkuReduction skuReduction = new SkuReduction();
                BeanUtils.copyProperties(sku, skuReduction);
                skuReduction.setSkuId(skuId);
                if (skuReduction.getFullCount() > 0 || skuReduction.getFullPrice().compareTo(new BigDecimal(0)) > 0)
                    couponFeignService.saveSkuReduction(skuReduction);
            });
        }
        // 保存sku的满减等信息
    }

    @Override
    public void saveBaseInfo(PmsSpuInfo pmsSpuInfo) {
        pmsSpuInfoMapper.insertSelective(pmsSpuInfo);
    }

    @Override
    public void saveSpuInfoDesc(PmsSpuInfoDesc pmsSpuInfoDesc) {
        pmsSpuInfoDescMapper.insertSelective(pmsSpuInfoDesc);
    }

    @Override
    public void saveImages(Long id, List<String> images) {
        if (images == null || images.size() == 0) {

        } else {
            images.stream().forEach(img -> {
                PmsSpuImages pmsSpuImages = new PmsSpuImages();
                pmsSpuImages.setSpuId(id);
                pmsSpuImages.setImgUrl(img);
                pmsSpuImagesMapper.insertSelective(pmsSpuImages);
            });
        }
    }

    @Override
    public void saveProductAttrValue(List<PmsProductAttrValue> collect) {
        collect.stream().distinct().forEach(item -> {
            pmsProductAttrValueMapper.insertSelective(item);
        });
    }

    @Override
    public void saveSkuInfo(PmsSkuInfo pmsSkuInfo) {
        pmsSkuInfoMapper.insertSelective(pmsSkuInfo);
    }

    @Override
    public void saveSkuImages(List<PmsSkuImages> collect1) {
        for (PmsSkuImages pmsSkuImages : collect1) {
            pmsSkuImagesMapper.insertSelective(pmsSkuImages);
        }
    }

    @Override
    public void saveSkuSaleAttrValue(List<PmsSkuSaleAttrValue> collect2) {
        for (PmsSkuSaleAttrValue pmsSkuSaleAttrValue : collect2) {
            pmsSkuSaleAttrValueMapper.insertSelective(pmsSkuSaleAttrValue);
        }
    }
}
