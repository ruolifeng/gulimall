package cn.rlfit.gulimallcoupon.controller;
import cn.rlfit.gulimallcoupon.domain.SmsCouponHistory;
import cn.rlfit.gulimallcoupon.service.impl.SmsCouponHistoryServiceImpl;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;

/**
* 优惠券领取历史记录(sms_coupon_history)表控制层
*
* @author xxxxx
*/
@RestController
@RequestMapping("/sms_coupon_history")
public class SmsCouponHistoryController {
/**
* 服务对象
*/
    @Autowired
    private SmsCouponHistoryServiceImpl smsCouponHistoryServiceImpl;

    /**
    * 通过主键查询单条数据
    *
    * @param id 主键
    * @return 单条数据
    */
    @GetMapping("selectOne")
    public SmsCouponHistory selectOne(Long id) {
    return smsCouponHistoryServiceImpl.selectByPrimaryKey(id);
    }

}
