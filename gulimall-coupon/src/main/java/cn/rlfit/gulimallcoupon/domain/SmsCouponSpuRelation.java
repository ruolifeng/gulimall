package cn.rlfit.gulimallcoupon.domain;

import lombok.Data;

/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 31/03/2024 1:10 PM
 */
/**
 * 优惠券与产品关联
 */
@Data
public class SmsCouponSpuRelation {
    /**
    * id
    */
    private Long id;

    /**
    * 优惠券id
    */
    private Long couponId;

    /**
    * spu_id
    */
    private Long spuId;

    /**
    * spu_name
    */
    private String spuName;
}