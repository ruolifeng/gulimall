package cn.rlfit.gulimall.to;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 31/03/2024 1:49 PM
 */
@Data
public class SpuBoundsTo {
    private Long spuId;
    private BigDecimal buyBounds;
    private BigDecimal growBounds;
}
