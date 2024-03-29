package cn.rlfit.gulimallmember.domain;

import java.util.Date;
import lombok.Data;

/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 29/03/2024 1:52 PM
 */
/**
 * 会员
 */
@Data
public class UmsMember {
    /**
    * id
    */
    private Long id;

    /**
    * 会员等级id
    */
    private Long levelId;

    /**
    * 用户名
    */
    private String username;

    /**
    * 密码
    */
    private String password;

    /**
    * 昵称
    */
    private String nickname;

    /**
    * 手机号码
    */
    private String mobile;

    /**
    * 邮箱
    */
    private String email;

    /**
    * 头像
    */
    private String header;

    /**
    * 性别
    */
    private Byte gender;

    /**
    * 生日
    */
    private Date birth;

    /**
    * 所在城市
    */
    private String city;

    /**
    * 职业
    */
    private String job;

    /**
    * 个性签名
    */
    private String sign;

    /**
    * 用户来源
    */
    private Byte sourceType;

    /**
    * 积分
    */
    private Integer integration;

    /**
    * 成长值
    */
    private Integer growth;

    /**
    * 启用状态
    */
    private Byte status;

    /**
    * 注册时间
    */
    private Date createTime;
}