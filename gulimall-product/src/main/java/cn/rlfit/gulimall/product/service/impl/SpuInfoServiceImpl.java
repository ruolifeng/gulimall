package cn.rlfit.gulimall.product.service.impl;

import cn.rlfit.gulimall.product.service.SpuInfoService;
import cn.rlfit.gulimall.product.vo.SpuSaveVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 30/03/2024 2:14 PM
 */
@Service
public class SpuInfoServiceImpl implements SpuInfoService {
    @Override
    @Transactional
    public void saveSpuInfo(SpuSaveVo vo) {
        // 保存spu的基本信息
        // 保存描述
        // 保存图片集合
        // 保存基本属性（规格参数）
        // 保存积分信息
        // 保存所有sku信息
        // 保存sku的基本信息
        // 保存sku的图片信息
        // 保存sku的销售属性值
        // 保存sku的优惠信息（跨库保存）
        // 保存sku的满减等信息
    }
}
