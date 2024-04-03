package cn.rlfit.gulimallware.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 03/04/2024 1:55 PM
 */
@Data
public class PurchaseDoneVo {
    @NotNull
    private Long id;
    private List<ItemDoneVo> items;
}
