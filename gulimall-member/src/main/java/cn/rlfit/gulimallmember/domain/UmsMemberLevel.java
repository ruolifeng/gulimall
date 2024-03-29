package cn.rlfit.gulimallmember.domain;

import java.math.BigDecimal;
import lombok.Data;

/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 29/03/2024 1:55 PM
 */
/**
 * 会员等级
 */
@Data
public class UmsMemberLevel {
    /**
    * id
    */
    private Long id;

    /**
    * 等级名称
    */
    private String name;

    /**
    * 等级需要的成长值
    */
    private Integer growthPoint;

    /**
    * 是否为默认等级[0->不是；1->是]
    */
    private Byte defaultStatus;

    /**
    * 免运费标准
    */
    private BigDecimal freeFreightPoint;

    /**
    * 每次评价获取的成长值
    */
    private Integer commentGrowthPoint;

    /**
    * 是否有免邮特权
    */
    private Byte priviledgeFreeFreight;

    /**
    * 是否有会员价格特权
    */
    private Byte priviledgeMemberPrice;

    /**
    * 是否有生日特权
    */
    private Byte priviledgeBirthday;

    /**
    * 备注
    */
    private String note;
}