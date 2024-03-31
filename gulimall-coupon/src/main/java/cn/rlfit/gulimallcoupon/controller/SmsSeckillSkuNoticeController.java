package cn.rlfit.gulimallcoupon.controller;
import cn.rlfit.gulimallcoupon.domain.SmsSeckillSkuNotice;
import cn.rlfit.gulimallcoupon.service.impl.SmsSeckillSkuNoticeServiceImpl;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;

/**
* 秒杀商品通知订阅(sms_seckill_sku_notice)表控制层
*
* @author xxxxx
*/
@RestController
@RequestMapping("/sms_seckill_sku_notice")
public class SmsSeckillSkuNoticeController {
/**
* 服务对象
*/
    @Autowired
    private SmsSeckillSkuNoticeServiceImpl smsSeckillSkuNoticeServiceImpl;

    /**
    * 通过主键查询单条数据
    *
    * @param id 主键
    * @return 单条数据
    */
    @GetMapping("selectOne")
    public SmsSeckillSkuNotice selectOne(Long id) {
    return smsSeckillSkuNoticeServiceImpl.selectByPrimaryKey(id);
    }

}
