package cn.rlfit.gulimall.product.controller;

import cn.rlfit.gulimall.product.domain.PmsCategoryBrandRelation;
import cn.rlfit.gulimall.product.service.PmsCategoryBrandRelationService;
import cn.rlfit.gulimall.utils.resp.R;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 12/03/2024 3:29 PM
 */
@RestController
public class PmsCategoryBrandRelationController {
    @Resource
    PmsCategoryBrandRelationService pmsCategoryBrandRelationservice;

    @GetMapping("/select/{id}")
    public R selectByPrimaryKey(@PathVariable("id") int id){
        PmsCategoryBrandRelation psm = pmsCategoryBrandRelationservice.selectByPrimaryKey(id);
         return R.ok("你好");
    }
}
