package cn.rlfit.gulimallmember.domain;

import java.math.BigDecimal;
import lombok.Data;

/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 29/03/2024 1:56 PM
 */
/**
 * 会员统计信息
 */
@Data
public class UmsMemberStatisticsInfo {
    /**
    * id
    */
    private Long id;

    /**
    * 会员id
    */
    private Long memberId;

    /**
    * 累计消费金额
    */
    private BigDecimal consumeAmount;

    /**
    * 累计优惠金额
    */
    private BigDecimal couponAmount;

    /**
    * 订单数量
    */
    private Integer orderCount;

    /**
    * 优惠券数量
    */
    private Integer couponCount;

    /**
    * 评价数
    */
    private Integer commentCount;

    /**
    * 退货数量
    */
    private Integer returnOrderCount;

    /**
    * 登录次数
    */
    private Integer loginCount;

    /**
    * 关注数量
    */
    private Integer attendCount;

    /**
    * 粉丝数量
    */
    private Integer fansCount;

    /**
    * 收藏的商品数量
    */
    private Integer collectProductCount;

    /**
    * 收藏的专题活动数量
    */
    private Integer collectSubjectCount;

    /**
    * 收藏的评论数量
    */
    private Integer collectCommentCount;

    /**
    * 邀请的朋友数量
    */
    private Integer inviteFriendCount;
}