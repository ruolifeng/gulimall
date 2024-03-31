package cn.rlfit.gulimallcoupon.domain;

import java.util.Date;
import lombok.Data;

/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 31/03/2024 1:10 PM
 */
/**
 * 秒杀活动
 */
@Data
public class SmsSeckillPromotion {
    /**
    * id
    */
    private Long id;

    /**
    * 活动标题
    */
    private String title;

    /**
    * 开始日期
    */
    private Date startTime;

    /**
    * 结束日期
    */
    private Date endTime;

    /**
    * 上下线状态
    */
    private Byte status;

    /**
    * 创建时间
    */
    private Date createTime;

    /**
    * 创建人
    */
    private Long userId;
}