package cn.rlfit.gulimall.product.controller;

import cn.rlfit.gulimall.product.domain.PageUtils;
import cn.rlfit.gulimall.product.domain.PmsAttrGroup;
import cn.rlfit.gulimall.product.service.PmsAttrGroupService;
import cn.rlfit.gulimall.utils.resp.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/save")
    public R save(@RequestBody Map<String, Object> pms){
        PmsAttrGroup pmsAttrGroup = new PmsAttrGroup();
        pmsAttrGroup.setAttrGroupName((String) pms.get("attrGroupName"));
        pmsAttrGroup.setDescript((String) pms.get("descript"));
        pmsAttrGroup.setIcon((String) pms.get("icon"));
        pmsAttrGroup.setCatelogId(((Integer)pms.get("catelogId")).longValue());
        pmsAttrGroup.setSort((Integer) pms.get("sort"));
        attrGroupService.save(pmsAttrGroup);
        return R.ok();
    }

    @PostMapping("/delete")
    public R delete(@RequestBody Long[] id){
        attrGroupService.delete(id);
        return R.ok();
    }
}
