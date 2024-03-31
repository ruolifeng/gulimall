package cn.rlfit.gulimallcoupon.controller;
import cn.rlfit.gulimallcoupon.domain.SmsMemberPrice;
import cn.rlfit.gulimallcoupon.service.impl.SmsMemberPriceServiceImpl;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;

/**
* 商品会员价格(sms_member_price)表控制层
*
* @author xxxxx
*/
@RestController
@RequestMapping("/sms_member_price")
public class SmsMemberPriceController {
/**
* 服务对象
*/
    @Autowired
    private SmsMemberPriceServiceImpl smsMemberPriceServiceImpl;

    /**
    * 通过主键查询单条数据
    *
    * @param id 主键
    * @return 单条数据
    */
    @GetMapping("selectOne")
    public SmsMemberPrice selectOne(Long id) {
    return smsMemberPriceServiceImpl.selectByPrimaryKey(id);
    }

}
