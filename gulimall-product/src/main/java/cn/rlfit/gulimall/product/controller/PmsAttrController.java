package cn.rlfit.gulimall.product.controller;

import cn.rlfit.gulimall.product.domain.PageUtils;
import cn.rlfit.gulimall.product.service.PmsAttrService;
import cn.rlfit.gulimall.product.service.PmsCategoryService;
import cn.rlfit.gulimall.product.vo.AttrRespVo;
import cn.rlfit.gulimall.product.vo.AttrVo;
import cn.rlfit.gulimall.utils.resp.R;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

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
    @Resource
    PmsCategoryService pmsCategoryService;

    @GetMapping("/{attrType}/list/{catId}")
    public R getBaseInfo(@PathVariable Integer catId, @RequestParam Map<String, Object> pms, @PathVariable String attrType) {
        PageUtils<AttrVo> vo = pmsAttrService.getInfo(catId, pms,attrType);
        return R.ok().put("data", vo);
    }

    /**
     * 保存属性数据
     * @param vo 传递过来的属性数据
     * @return 属性数据保存成功
     */
    @PostMapping("/save")
    public R save(@RequestBody AttrVo vo) {
        System.out.println(vo);
        pmsAttrService.saveAttr(vo);
        return R.ok();
    }

    /**
     * 当用户点击修改属性信息的时候回显属性信息
     * @param id 属性id
     * @return 获取单个属性信息成功
     */
    @GetMapping("/info/{id}")
    public R getOneInfo(@PathVariable Long id) {
        AttrRespVo vo = pmsAttrService.getOneInfo(id);
        if (vo.getCatelogId() != null) {
            Long[] catelongPath = pmsCategoryService.findCatelongPath(vo.getCatelogId());
            vo.setCatalogPath(catelongPath);
        }
        return R.ok().put("data", vo);
    }

    /**
     * 更新数据
     * @param vo 更新数据
     * @return 更新成功
     */
    @PostMapping("/update")
    public R update(@RequestBody AttrRespVo vo) {
        pmsAttrService.update(vo);
        return R.ok();
    }

    @PostMapping("/delete")
    public R delete(@RequestBody Long[] ids) {
        pmsAttrService.delete(ids);
        return R.ok();
    }
}
