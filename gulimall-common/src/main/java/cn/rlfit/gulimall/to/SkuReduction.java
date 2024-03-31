package cn.rlfit.gulimall.to;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 31/03/2024 2:03 PM
 */
@Data
public class SkuReduction {
    private Long skuId;
    private int fullCount;
    private BigDecimal discount;
    private int countStatus;
    private BigDecimal fullPrice;
    private BigDecimal reducePrice;
    private int priceStatus;
    private List<MemberPrice> memberPrice;
}
