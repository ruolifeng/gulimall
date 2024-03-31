package cn.rlfit.gulimallcoupon.controller;
import cn.rlfit.gulimallcoupon.domain.SmsCoupon;
import cn.rlfit.gulimallcoupon.service.impl.SmsCouponServiceImpl;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;

/**
* 优惠券信息(sms_coupon)表控制层
*
* @author xxxxx
*/
@RestController
@RequestMapping("/sms_coupon")
public class SmsCouponController {
/**
* 服务对象
*/
    @Autowired
    private SmsCouponServiceImpl smsCouponServiceImpl;

    /**
    * 通过主键查询单条数据
    *
    * @param id 主键
    * @return 单条数据
    */
    @GetMapping("selectOne")
    public SmsCoupon selectOne(Long id) {
    return smsCouponServiceImpl.selectByPrimaryKey(id);
    }

}
