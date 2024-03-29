package cn.rlfit.gulimallmember.domain;

import java.util.Date;
import lombok.Data;

/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 29/03/2024 1:55 PM
 */
/**
 * 积分变化历史记录
 */
@Data
public class UmsIntegrationChangeHistory {
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
    * 变化的值
    */
    private Integer changeCount;

    /**
    * 备注
    */
    private String note;

    /**
    * 来源[0->购物；1->管理员修改;2->活动]
    */
    private Byte sourceTyoe;
}