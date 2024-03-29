package cn.rlfit.gulimallmember.domain;

import java.util.Date;
import lombok.Data;

/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 29/03/2024 1:55 PM
 */
/**
 * 成长值变化历史记录
 */
@Data
public class UmsGrowthChangeHistory {
    /**
    * id
    */
    private Long id;

    /**
    * member_id
    */
    private Long memberId;

    /**
    * create_time
    */
    private Date createTime;

    /**
    * 改变的值（正负计数）
    */
    private Integer changeCount;

    /**
    * 备注
    */
    private String note;

    /**
    * 积分来源[0-购物，1-管理员修改]
    */
    private Byte sourceType;
}