package cn.rlfit.gulimall.product.service.impl;

import cn.rlfit.gulimall.product.domain.*;
import cn.rlfit.gulimall.product.mapper.*;
import cn.rlfit.gulimall.product.service.SpuInfoService;
import cn.rlfit.gulimall.product.vo.BaseAttrs;
import cn.rlfit.gulimall.product.vo.SpuSaveVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
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
        // TODO id可能获取不到
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
        // 保存积分信息
        // 保存所有sku信息
        // 保存sku的基本信息
        // 保存sku的图片信息
        // 保存sku的销售属性值
        // 保存sku的优惠信息（跨库保存）
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
        collect.stream().distinct().forEach(item->{
            pmsProductAttrValueMapper.insertSelective(item);
        });
    }
}
