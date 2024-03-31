package cn.rlfit.gulimallcoupon.controller;
import cn.rlfit.gulimallcoupon.domain.SmsSeckillPromotion;
import cn.rlfit.gulimallcoupon.service.impl.SmsSeckillPromotionServiceImpl;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;

/**
* 秒杀活动(sms_seckill_promotion)表控制层
*
* @author xxxxx
*/
@RestController
@RequestMapping("/sms_seckill_promotion")
public class SmsSeckillPromotionController {
/**
* 服务对象
*/
    @Autowired
    private SmsSeckillPromotionServiceImpl smsSeckillPromotionServiceImpl;

    /**
    * 通过主键查询单条数据
    *
    * @param id 主键
    * @return 单条数据
    */
    @GetMapping("selectOne")
    public SmsSeckillPromotion selectOne(Long id) {
    return smsSeckillPromotionServiceImpl.selectByPrimaryKey(id);
    }

}
