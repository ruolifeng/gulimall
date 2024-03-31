package cn.rlfit.gulimallcoupon.controller;
import cn.rlfit.gulimallcoupon.domain.SmsCouponSpuRelation;
import cn.rlfit.gulimallcoupon.service.impl.SmsCouponSpuRelationServiceImpl;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;

/**
* 优惠券与产品关联(sms_coupon_spu_relation)表控制层
*
* @author xxxxx
*/
@RestController
@RequestMapping("/sms_coupon_spu_relation")
public class SmsCouponSpuRelationController {
/**
* 服务对象
*/
    @Autowired
    private SmsCouponSpuRelationServiceImpl smsCouponSpuRelationServiceImpl;

    /**
    * 通过主键查询单条数据
    *
    * @param id 主键
    * @return 单条数据
    */
    @GetMapping("selectOne")
    public SmsCouponSpuRelation selectOne(Long id) {
    return smsCouponSpuRelationServiceImpl.selectByPrimaryKey(id);
    }

}
