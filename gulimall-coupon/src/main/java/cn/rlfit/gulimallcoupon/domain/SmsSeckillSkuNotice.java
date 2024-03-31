package cn.rlfit.gulimallcoupon.domain;

import java.util.Date;
import lombok.Data;

/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 31/03/2024 1:13 PM
 */
/**
 * 秒杀商品通知订阅
 */
@Data
public class SmsSeckillSkuNotice {
    /**
    * id
    */
    private Long id;

    /**
    * member_id
    */
    private Long memberId;

    /**
    * sku_id
    */
    private Long skuId;

    /**
    * 活动场次id
    */
    private Long sessionId;

    /**
    * 订阅时间
    */
    private Date subcribeTime;

    /**
    * 发送时间
    */
    private Date sendTime;

    /**
    * 通知方式[0-短信，1-邮件]
    */
    private Boolean noticeType;
}