package cn.rlfit.gulimallcoupon.domain;

import java.math.BigDecimal;
import lombok.Data;

/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 31/03/2024 1:17 PM
 */
/**
 * 商品spu积分设置
 */
@Data
public class SmsSpuBounds {
    /**
    * id
    */
    private Long id;

    private Long spuId;

    /**
    * 成长积分
    */
    private BigDecimal growBounds;

    /**
    * 购物积分
    */
    private BigDecimal buyBounds;

    /**
    * 优惠生效情况[1111（四个状态位，从右到左）;0 - 无优惠，成长积分是否赠送;1 - 无优惠，购物积分是否赠送;2 - 有优惠，成长积分是否赠送;3 - 有优惠，购物积分是否赠送【状态位0：不赠送，1：赠送】]
    */
    private Boolean work;
}