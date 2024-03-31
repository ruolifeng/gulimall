package cn.rlfit.gulimallcoupon.domain;

import java.math.BigDecimal;
import lombok.Data;

/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 31/03/2024 1:16 PM
 */
/**
 * 商品满减信息
 */
@Data
public class SmsSkuFullReduction {
    /**
    * id
    */
    private Long id;

    /**
    * spu_id
    */
    private Long skuId;

    /**
    * 满多少
    */
    private BigDecimal fullPrice;

    /**
    * 减多少
    */
    private BigDecimal reducePrice;

    /**
    * 是否参与其他优惠
    */
    private Boolean addOther;
}