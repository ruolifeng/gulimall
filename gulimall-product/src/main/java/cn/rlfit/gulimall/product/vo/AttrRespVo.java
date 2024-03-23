package cn.rlfit.gulimall.product.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 23/03/2024 2:38 PM
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class AttrRespVo extends AttrVo{
    String groupName;
    String catelogName;
}
