package cn.rlfit.gulimallcoupon.domain;

import lombok.Data;

/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 31/03/2024 1:10 PM
 */
/**
 * 首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】
 */
@Data
public class SmsHomeSubject {
    /**
    * id
    */
    private Long id;

    /**
    * 专题名字
    */
    private String name;

    /**
    * 专题标题
    */
    private String title;

    /**
    * 专题副标题
    */
    private String subTitle;

    /**
    * 显示状态
    */
    private Boolean status;

    /**
    * 详情连接
    */
    private String url;

    /**
    * 排序
    */
    private Integer sort;

    /**
    * 专题图片地址
    */
    private String img;
}