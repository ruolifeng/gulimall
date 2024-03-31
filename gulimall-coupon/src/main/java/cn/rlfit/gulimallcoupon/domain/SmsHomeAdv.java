package cn.rlfit.gulimallcoupon.domain;

import java.util.Date;
import lombok.Data;

/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 31/03/2024 1:10 PM
 */
/**
 * 首页轮播广告
 */
@Data
public class SmsHomeAdv {
    /**
    * id
    */
    private Long id;

    /**
    * 名字
    */
    private String name;

    /**
    * 图片地址
    */
    private String pic;

    /**
    * 开始时间
    */
    private Date startTime;

    /**
    * 结束时间
    */
    private Date endTime;

    /**
    * 状态
    */
    private Boolean status;

    /**
    * 点击数
    */
    private Integer clickCount;

    /**
    * 广告详情连接地址
    */
    private String url;

    /**
    * 备注
    */
    private String note;

    /**
    * 排序
    */
    private Integer sort;

    /**
    * 发布者
    */
    private Long publisherId;

    /**
    * 审核者
    */
    private Long authId;
}