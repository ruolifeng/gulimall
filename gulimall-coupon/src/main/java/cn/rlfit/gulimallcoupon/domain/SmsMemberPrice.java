package cn.rlfit.gulimallcoupon.domain;

import java.math.BigDecimal;
import lombok.Data;

/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 31/03/2024 1:10 PM
 */
/**
 * 商品会员价格
 */
@Data
public class SmsMemberPrice {
    /**
    * id
    */
    private Long id;

    /**
    * sku_id
    */
    private Long skuId;

    /**
    * 会员等级id
    */
    private Long memberLevelId;

    /**
    * 会员等级名
    */
    private String memberLevelName;

    /**
    * 会员对应价格
    */
    private BigDecimal memberPrice;

    /**
    * 可否叠加其他优惠[0-不可叠加优惠，1-可叠加]
    */
    private Boolean addOther;
}