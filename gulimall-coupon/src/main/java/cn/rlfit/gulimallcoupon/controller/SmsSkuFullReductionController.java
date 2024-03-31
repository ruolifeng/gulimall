package cn.rlfit.gulimallcoupon.controller;

import cn.rlfit.gulimall.to.SkuReduction;
import cn.rlfit.gulimall.utils.resp.R;
import cn.rlfit.gulimallcoupon.domain.SmsSkuFullReduction;
import cn.rlfit.gulimallcoupon.service.impl.SmsSkuFullReductionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
* 商品满减信息(sms_sku_full_reduction)表控制层
*
* @author xxxxx
*/
@RestController
@RequestMapping("/coupon/skufullreduction")
public class SmsSkuFullReductionController {
/**
* 服务对象
*/
    @Autowired
    private SmsSkuFullReductionServiceImpl smsSkuFullReductionServiceImpl;

    /**
    * 通过主键查询单条数据
    *
    * @param id 主键
    * @return 单条数据
    */
    @GetMapping("selectOne")
    public SmsSkuFullReduction selectOne(Long id) {
    return smsSkuFullReductionServiceImpl.selectByPrimaryKey(id);
    }

    @PostMapping("/saveInfo")
    public R saveInfo(@RequestBody SkuReduction skuReduction){
        smsSkuFullReductionServiceImpl.saveSkuReduciton(skuReduction);
        return R.ok();
    }
}
