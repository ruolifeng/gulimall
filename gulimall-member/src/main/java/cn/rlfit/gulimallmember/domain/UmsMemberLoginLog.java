package cn.rlfit.gulimallmember.domain;

import java.util.Date;
import lombok.Data;

/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 29/03/2024 1:56 PM
 */
/**
 * 会员登录记录
 */
@Data
public class UmsMemberLoginLog {
    /**
    * id
    */
    private Long id;

    /**
    * member_id
    */
    private Long memberId;

    /**
    * 创建时间
    */
    private Date createTime;

    /**
    * ip
    */
    private String ip;

    /**
    * city
    */
    private String city;

    /**
    * 登录类型[1-web，2-app]
    */
    private Boolean loginType;
}