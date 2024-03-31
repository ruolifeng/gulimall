package cn.rlfit.gulimallcoupon.domain;

import lombok.Data;

/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 31/03/2024 1:10 PM
 */
/**
 * 专题商品
 */
@Data
public class SmsHomeSubjectSpu {
    /**
    * id
    */
    private Long id;

    /**
    * 专题名字
    */
    private String name;

    /**
    * 专题id
    */
    private Long subjectId;

    /**
    * spu_id
    */
    private Long spuId;

    /**
    * 排序
    */
    private Integer sort;
}