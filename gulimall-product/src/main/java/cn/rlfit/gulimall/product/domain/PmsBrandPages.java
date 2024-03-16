package cn.rlfit.gulimall.product.domain;

import lombok.Data;

import java.util.List;

/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 16/03/2024 4:35 PM
 */
@Data
public class PmsBrandPages {
    private List<PmsBrand> data;
    private Integer totalPage;
}
