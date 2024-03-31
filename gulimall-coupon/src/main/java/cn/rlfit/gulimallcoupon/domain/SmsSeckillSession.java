package cn.rlfit.gulimallcoupon.domain;

import java.util.Date;
import lombok.Data;

/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 31/03/2024 1:11 PM
 */
/**
 * 秒杀活动场次
 */
@Data
public class SmsSeckillSession {
    /**
    * id
    */
    private Long id;

    /**
    * 场次名称
    */
    private String name;

    /**
    * 每日开始时间
    */
    private Date startTime;

    /**
    * 每日结束时间
    */
    private Date endTime;

    /**
    * 启用状态
    */
    private Boolean status;

    /**
    * 创建时间
    */
    private Date createTime;
}