package cn.rlfit.gulimall.product.controller;

import cn.rlfit.gulimall.product.domain.PageUtils;
import cn.rlfit.gulimall.product.domain.PmsAttr;
import cn.rlfit.gulimall.product.domain.PmsAttrGroup;
import cn.rlfit.gulimall.product.service.PmsAttrGroupService;
import cn.rlfit.gulimall.product.service.PmsAttrRelationService;
import cn.rlfit.gulimall.product.service.PmsAttrService;
import cn.rlfit.gulimall.product.service.PmsCategoryService;
import cn.rlfit.gulimall.product.vo.AttrGroupRelationVo;
import cn.rlfit.gulimall.product.vo.AttrRespVo;
import cn.rlfit.gulimall.utils.resp.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
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

    @Autowired
    private PmsCategoryService pmsCategoryService;

    @Resource
    private PmsAttrService pmsAttrService;


    @Resource
    PmsAttrRelationService pmsAttrRelationService;

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
        pmsAttrGroup.setSort(Integer.parseInt((String) pms.get("sort")));
        attrGroupService.save(pmsAttrGroup);
        return R.ok();
    }

    @PostMapping("/delete")
    public R delete(@RequestBody Long[] id){
        attrGroupService.delete(id);
        return R.ok();
    }

    @GetMapping("/info/{id}")
    public R getInfo(@PathVariable Long id){
        PmsAttrGroup pmsAttrGroup = attrGroupService.getInfo(id);
        Long[] path = pmsCategoryService.findCatelongPath(pmsAttrGroup.getCatelogId());
        pmsAttrGroup.setCateLogPath(path);
        return R.ok().put("data", pmsAttrGroup);
    }

    @PostMapping("/update")
    public R update(@RequestBody PmsAttrGroup pmsAttrGroup){
        attrGroupService.update(pmsAttrGroup);
        return R.ok();
    }

    /**
     * 获取分组关联的所有属性信息
     * @param attrGroup
     * @return
     */
    @GetMapping("/{attrGroup}/attr/relation")
    public R getAttrRelation(@PathVariable Long attrGroup) {
        List<PmsAttr> pmsAttrs = pmsAttrService.getRelationAttr(attrGroup);
        return R.ok().put("data", pmsAttrs);
    }
    @PostMapping("/attr/relation/delete")
    public R deleteRelation(@RequestBody AttrRespVo[] attrRespVos) {
        pmsAttrService.deleteRelation(attrRespVos);
        return R.ok();
    }

    /**
     * 获取分组未关联的属性信息
     * @param attrGroup
     * @param pms
     * @return
     */
    @GetMapping("/{attrGroup}/noattr/relation")
    public R getNoRelationAttr(@PathVariable Long attrGroup,@RequestParam Map<String, Object> pms) {
        PageUtils<PmsAttr> page =  pmsAttrService.getNoRelationAttr(attrGroup,pms);
        return R.ok().put("data", page);
    }

    @PostMapping("/attr/relation")
    public R addRelation(@RequestBody List<AttrGroupRelationVo> vo){
        pmsAttrRelationService.addRelation(vo);
        return R.ok();
    }
}
