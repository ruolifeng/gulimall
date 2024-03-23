package cn.rlfit.gulimall.product.controller;

import cn.rlfit.gulimall.product.service.PmsAttrService;
import cn.rlfit.gulimall.product.vo.AttrVo;
import cn.rlfit.gulimall.utils.resp.R;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 22/03/2024 9:45 PM
 */
@RestController
@RequestMapping("/product/attr")
public class PmsAttrController {
    @Resource
    PmsAttrService pmsAttrService;
    @GetMapping("/base/list/{catId}")
    public R getBaseInfo(@PathVariable Integer catId){
        List<AttrVo> vo =  pmsAttrService.getInfo(catId);;
        return R.ok().put("data", vo);
    }

    /**
     * 保存属性数据
     * @param vo 传递过来的属性数据
     * @return 属性数据保存成功
     */
    @PostMapping("/save")
    public R save(@RequestBody AttrVo vo){
        System.out.println(vo);
        pmsAttrService.saveAttr(vo);
        return R.ok();
    }
}
