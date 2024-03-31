package cn.rlfit.gulimallcoupon.domain;

import lombok.Data;

/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 31/03/2024 1:15 PM
 */
/**
 * 秒杀活动商品关联
 */
@Data
public class SmsSeckillSkuRelation {
    /**
    * id
    */
    private Long id;

    /**
    * 活动id
    */
    private Long promotionId;

    /**
    * 活动场次id
    */
    private Long promotionSessionId;

    /**
    * 商品id
    */
    private Long skuId;

    /**
    * 秒杀价格
    */
    private Long seckillPrice;

    /**
    * 秒杀总量
    */
    private Long seckillCount;

    /**
    * 每人限购数量
    */
    private Long seckillLimit;

    /**
    * 排序
    */
    private Integer seckillSort;
}