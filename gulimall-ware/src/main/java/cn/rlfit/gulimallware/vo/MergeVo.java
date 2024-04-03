package cn.rlfit.gulimallware.vo;

import lombok.Data;

import java.util.List;

/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 03/04/2024 11:31 AM
 */
@Data
public class MergeVo {
    private Long purchaseId;
    private List<Long> items;
}
