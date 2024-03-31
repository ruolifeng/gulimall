package cn.rlfit.gulimallcoupon.domain;

import lombok.Data;

/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 31/03/2024 1:10 PM
 */
/**
 * 优惠券分类关联
 */
@Data
public class SmsCouponSpuCategoryRelation {
    /**
    * id
    */
    private Long id;

    /**
    * 优惠券id
    */
    private Long couponId;

    /**
    * 产品分类id
    */
    private Long categoryId;

    /**
    * 产品分类名称
    */
    private String categoryName;
}