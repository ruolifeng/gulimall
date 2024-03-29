package cn.rlfit.gulimall.product.vo;

import cn.rlfit.gulimall.product.domain.PmsAttr;
import lombok.Data;

import java.util.List;

/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 29/03/2024 9:22 PM
 */
@Data
public class AttrGroupWithAttrsVo {
    /**
     * 分组id
     */
    private Long attrGroupId;

    /**
     * 组名
     */
    private String attrGroupName;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 描述
     */
    private String descript;

    /**
     * 组图标
     */
    private String icon;

    /**
     * 所属分类id
     */
    private Long catelogId;
    private List<PmsAttr> attrs;
}
