package cn.rlfit.gulimallcoupon.controller;
import cn.rlfit.gulimallcoupon.domain.SmsSeckillSession;
import cn.rlfit.gulimallcoupon.service.impl.SmsSeckillSessionServiceImpl;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;

/**
* 秒杀活动场次(sms_seckill_session)表控制层
*
* @author xxxxx
*/
@RestController
@RequestMapping("/sms_seckill_session")
public class SmsSeckillSessionController {
/**
* 服务对象
*/
    @Autowired
    private SmsSeckillSessionServiceImpl smsSeckillSessionServiceImpl;

    /**
    * 通过主键查询单条数据
    *
    * @param id 主键
    * @return 单条数据
    */
    @GetMapping("selectOne")
    public SmsSeckillSession selectOne(Long id) {
    return smsSeckillSessionServiceImpl.selectByPrimaryKey(id);
    }

}
