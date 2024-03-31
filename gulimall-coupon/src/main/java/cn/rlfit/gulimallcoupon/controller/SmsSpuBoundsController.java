package cn.rlfit.gulimallcoupon.controller;

import cn.rlfit.gulimall.utils.resp.R;
import cn.rlfit.gulimallcoupon.domain.SmsSpuBounds;
import cn.rlfit.gulimallcoupon.service.impl.SmsSpuBoundsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
* 商品spu积分设置(sms_spu_bounds)表控制层
*
* @author xxxxx
*/
@RestController
@RequestMapping("/coupon/spubounds")
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

    @PostMapping("/save")
    public R save(@RequestBody SmsSpuBounds smsSpuBounds){
        smsSpuBoundsServiceImpl.insertSelective(smsSpuBounds);
        return R.ok();
    }
}
