package cn.rlfit.gulimallcoupon.controller;
import cn.rlfit.gulimallcoupon.domain.SmsSeckillSkuRelation;
import cn.rlfit.gulimallcoupon.service.impl.SmsSeckillSkuRelationServiceImpl;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;

/**
* 秒杀活动商品关联(sms_seckill_sku_relation)表控制层
*
* @author xxxxx
*/
@RestController
@RequestMapping("/sms_seckill_sku_relation")
public class SmsSeckillSkuRelationController {
/**
* 服务对象
*/
    @Autowired
    private SmsSeckillSkuRelationServiceImpl smsSeckillSkuRelationServiceImpl;

    /**
    * 通过主键查询单条数据
    *
    * @param id 主键
    * @return 单条数据
    */
    @GetMapping("selectOne")
    public SmsSeckillSkuRelation selectOne(Long id) {
    return smsSeckillSkuRelationServiceImpl.selectByPrimaryKey(id);
    }

}
