package cn.rlfit.gulimallmember.domain;

import java.util.Date;
import lombok.Data;

/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 29/03/2024 1:55 PM
 */
/**
 * 会员收藏的商品
 */
@Data
public class UmsMemberCollectSpu {
    /**
    * id
    */
    private Long id;

    /**
    * 会员id
    */
    private Long memberId;

    /**
    * spu_id
    */
    private Long spuId;

    /**
    * spu_name
    */
    private String spuName;

    /**
    * spu_img
    */
    private String spuImg;

    /**
    * create_time
    */
    private Date createTime;
}