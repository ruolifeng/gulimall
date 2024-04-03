package cn.rlfit.gulimallware.vo;

import lombok.Data;

/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 03/04/2024 1:56 PM
 */
@Data
public class ItemDoneVo {
    private Long itemId;
    private Integer status;
    private String reason;
}
