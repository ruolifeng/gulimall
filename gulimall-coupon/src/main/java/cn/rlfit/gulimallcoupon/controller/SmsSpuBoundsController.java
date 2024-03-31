package cn.rlfit.gulimallcoupon.controller;
import cn.rlfit.gulimallcoupon.domain.SmsSpuBounds;
import cn.rlfit.gulimallcoupon.service.impl.SmsSpuBoundsServiceImpl;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;

/**
* 商品spu积分设置(sms_spu_bounds)表控制层
*
* @author xxxxx
*/
@RestController
@RequestMapping("/sms_spu_bounds")
public class SmsSpuBoundsController {
/**
* 服务对象
*/
    @Autowired
    private SmsSpuBoundsServiceImpl smsSpuBoundsServiceImpl;

    /**
    * 通过主键查询单条数据
    *
    * @param id 主键
    * @return 单条数据
    */
    @GetMapping("selectOne")
    public SmsSpuBounds selectOne(Long id) {
    return smsSpuBoundsServiceImpl.selectByPrimaryKey(id);
    }

}
