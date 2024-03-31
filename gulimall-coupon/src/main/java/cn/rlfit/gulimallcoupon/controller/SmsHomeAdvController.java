package cn.rlfit.gulimallcoupon.controller;
import cn.rlfit.gulimallcoupon.domain.SmsHomeAdv;
import cn.rlfit.gulimallcoupon.service.impl.SmsHomeAdvServiceImpl;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;

/**
* 首页轮播广告(sms_home_adv)表控制层
*
* @author xxxxx
*/
@RestController
@RequestMapping("/sms_home_adv")
public class SmsHomeAdvController {
/**
* 服务对象
*/
    @Autowired
    private SmsHomeAdvServiceImpl smsHomeAdvServiceImpl;

    /**
    * 通过主键查询单条数据
    *
    * @param id 主键
    * @return 单条数据
    */
    @GetMapping("selectOne")
    public SmsHomeAdv selectOne(Long id) {
    return smsHomeAdvServiceImpl.selectByPrimaryKey(id);
    }

}
