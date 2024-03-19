package cn.rlfit.gulimall.product.controller;

import cn.rlfit.gulimall.product.domain.PageUtils;
import cn.rlfit.gulimall.product.domain.PmsAttrGroup;
import cn.rlfit.gulimall.product.service.PmsAttrGroupService;
import cn.rlfit.gulimall.utils.resp.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 19/03/2024 11:10 AM
 */
@RestController
@RequestMapping("/product/attrgroup")
public class PmsAttrGroupController {
    @Autowired
    private PmsAttrGroupService attrGroupService;

    @RequestMapping("/list/{catalogId}")
    public R list(@RequestParam Map<String, Object> pms, @PathVariable Long catalogId){
        PageUtils<PmsAttrGroup> page = attrGroupService.queryPage(pms,catalogId);
        return R.ok().put("data", page);
    }
}
