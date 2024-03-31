package cn.rlfit.gulimallcoupon.controller;
import cn.rlfit.gulimallcoupon.domain.SmsCouponSpuCategoryRelation;
import cn.rlfit.gulimallcoupon.service.impl.SmsCouponSpuCategoryRelationServiceImpl;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;

/**
* 优惠券分类关联(sms_coupon_spu_category_relation)表控制层
*
* @author xxxxx
*/
@RestController
@RequestMapping("/sms_coupon_spu_category_relation")
public class SmsCouponSpuCategoryRelationController {
/**
* 服务对象
*/
    @Autowired
    private SmsCouponSpuCategoryRelationServiceImpl smsCouponSpuCategoryRelationServiceImpl;

    /**
    * 通过主键查询单条数据
    *
    * @param id 主键
    * @return 单条数据
    */
    @GetMapping("selectOne")
    public SmsCouponSpuCategoryRelation selectOne(Long id) {
    return smsCouponSpuCategoryRelationServiceImpl.selectByPrimaryKey(id);
    }

}
