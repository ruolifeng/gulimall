package cn.rlfit.gulimallcoupon.domain;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 31/03/2024 1:09 PM
 */
/**
 * 优惠券信息
 */
@Data
public class SmsCoupon {
    /**
    * id
    */
    private Long id;

    /**
    * 优惠卷类型[0->全场赠券；1->会员赠券；2->购物赠券；3->注册赠券]
    */
    private Boolean couponType;

    /**
    * 优惠券图片
    */
    private String couponImg;

    /**
    * 优惠卷名字
    */
    private String couponName;

    /**
    * 数量
    */
    private Integer num;

    /**
    * 金额
    */
    private BigDecimal amount;

    /**
    * 每人限领张数
    */
    private Integer perLimit;

    /**
    * 使用门槛
    */
    private BigDecimal minPoint;

    /**
    * 开始时间
    */
    private Date startTime;

    /**
    * 结束时间
    */
    private Date endTime;

    /**
    * 使用类型[0->全场通用；1->指定分类；2->指定商品]
    */
    private Boolean useType;

    /**
    * 备注
    */
    private String note;

    /**
    * 发行数量
    */
    private Integer publishCount;

    /**
    * 已使用数量
    */
    private Integer useCount;

    /**
    * 领取数量
    */
    private Integer receiveCount;

    /**
    * 可以领取的开始日期
    */
    private Date enableStartTime;

    /**
    * 可以领取的结束日期
    */
    private Date enableEndTime;

    /**
    * 优惠码
    */
    private String code;

    /**
    * 可以领取的会员等级[0->不限等级，其他-对应等级]
    */
    private Boolean memberLevel;

    /**
    * 发布状态[0-未发布，1-已发布]
    */
    private Boolean publish;
}