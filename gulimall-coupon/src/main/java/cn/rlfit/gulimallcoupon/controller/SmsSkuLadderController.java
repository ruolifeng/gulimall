package cn.rlfit.gulimallcoupon.controller;
import cn.rlfit.gulimallcoupon.domain.SmsSkuLadder;
import cn.rlfit.gulimallcoupon.service.impl.SmsSkuLadderServiceImpl;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;

/**
* 商品阶梯价格(sms_sku_ladder)表控制层
*
* @author xxxxx
*/
@RestController
@RequestMapping("/sms_sku_ladder")
public class SmsSkuLadderController {
/**
* 服务对象
*/
    @Autowired
    private SmsSkuLadderServiceImpl smsSkuLadderServiceImpl;

    /**
    * 通过主键查询单条数据
    *
    * @param id 主键
    * @return 单条数据
    */
    @GetMapping("selectOne")
    public SmsSkuLadder selectOne(Long id) {
    return smsSkuLadderServiceImpl.selectByPrimaryKey(id);
    }

}
