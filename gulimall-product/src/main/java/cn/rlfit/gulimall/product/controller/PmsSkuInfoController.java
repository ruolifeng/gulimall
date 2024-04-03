package cn.rlfit.gulimall.product.controller;

import cn.rlfit.gulimall.product.domain.PmsSkuInfo;
import cn.rlfit.gulimall.product.service.PmsSkuInfoService;
import cn.rlfit.gulimall.utils.resp.Page;
import cn.rlfit.gulimall.utils.resp.R;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 01/04/2024 9:31 AM
 */
@RestController
@RequestMapping("/product/skuinfo")
public class PmsSkuInfoController {
    @Resource
    private PmsSkuInfoService pmsSkuInfoService;
    @GetMapping("/list")
    public R getSkuInfoList(@RequestParam Map<String,Object> params){
       Page<List<PmsSkuInfo>> pageData =  pmsSkuInfoService.getSkuInfoList(params);
        return R.ok().put("data", pageData);
    }

    @GetMapping("/info/{skuId}")
    public R info(@PathVariable Long skuId){
       PmsSkuInfo info =  pmsSkuInfoService.getSkuInfoById(skuId);
       return R.ok().put("data", info);
    }
}
