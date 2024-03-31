package cn.rlfit.gulimall.product.controller;

import cn.rlfit.gulimall.product.domain.PmsSpuInfo;
import cn.rlfit.gulimall.product.service.SpuInfoService;
import cn.rlfit.gulimall.product.vo.SpuSaveVo;
import cn.rlfit.gulimall.utils.resp.Page;
import cn.rlfit.gulimall.utils.resp.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 30/03/2024 2:07 PM
 */
@RestController
@RequestMapping("/product/spuinfo")
public class SpuInfoController {
    @Autowired
    SpuInfoService spuInfoService;
    @PostMapping("/save")
    public R save(@RequestBody SpuSaveVo vo){
        spuInfoService.saveSpuInfo(vo);
        return R.ok();
    }
    @GetMapping("/list")
    public R getAll(@RequestParam Map<String,Object> pms){
        Page<List<PmsSpuInfo>> listAll = spuInfoService.getAllByCondition(pms);
        return R.ok().put("data",listAll);
    }
}
