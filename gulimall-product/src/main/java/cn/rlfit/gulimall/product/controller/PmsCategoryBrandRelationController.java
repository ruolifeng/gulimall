package cn.rlfit.gulimall.product.controller;

import cn.rlfit.gulimall.product.domain.PmsBrand;
import cn.rlfit.gulimall.product.domain.PmsCategory;
import cn.rlfit.gulimall.product.domain.PmsCategoryBrandRelation;
import cn.rlfit.gulimall.product.service.PmsBrandService;
import cn.rlfit.gulimall.product.service.PmsCategoryBrandRelationService;
import cn.rlfit.gulimall.product.service.PmsCategoryService;
import cn.rlfit.gulimall.product.vo.BrandVo;
import cn.rlfit.gulimall.utils.resp.R;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 12/03/2024 3:29 PM
 */
@RestController
@RequestMapping("/product/categorybrandrelation")
public class PmsCategoryBrandRelationController {
    @Resource
    PmsCategoryBrandRelationService pmsCategoryBrandRelationservice;
    @Resource
    PmsBrandService pmsBrandService;
    @Resource
    PmsCategoryService pmsCategoryService;
    /**
     * 获取当前品牌关联的所有分类
     * @param brandId 分类id
     * @return 返回分类数据
     */
    @GetMapping("catelog/list")
    public R getRelation(@RequestParam Long brandId){
        List<PmsCategoryBrandRelation> relations =  pmsCategoryBrandRelationservice.getRelation(brandId);
        return R.ok().put("data", relations);
    }

    @PostMapping("/save")
    public R save(@RequestBody Map<String,Long> pms){
        PmsCategoryBrandRelation relation = new PmsCategoryBrandRelation();
        relation.setBrandId(pms.get("brandId"));
        relation.setCatelogId(pms.get("catelogId"));
        PmsBrand oneInfo = pmsBrandService.getOneInfo(Math.toIntExact(pms.get("brandId")));
        relation.setBrandName(oneInfo.getName());
        PmsCategory pmsCategory = pmsCategoryService.getOneInfoById(pms.get("catelogId"));
        relation.setCatelogName(pmsCategory.getName());
        pmsCategoryBrandRelationservice.save(relation);
        return R.ok();
    }
    @PostMapping("delete")
    public R deleteById(@RequestBody Long[] ids){
        pmsCategoryBrandRelationservice.delete(ids);
        return R.ok();
    }

    @GetMapping("/brands/list")
    public R relationBrandList(@RequestParam Long catId){
        List<PmsBrand> brands = pmsCategoryBrandRelationservice.getBrandsByCatId(catId);
        List<BrandVo> collect = brands.stream().map(item -> {
            BrandVo brandVo = new BrandVo();
            brandVo.setBrandId(item.getBrandId());
            brandVo.setBrandName(item.getName());
            return brandVo;
        }).collect(Collectors.toList());
        return R.ok().put("data", collect);
    }
}
