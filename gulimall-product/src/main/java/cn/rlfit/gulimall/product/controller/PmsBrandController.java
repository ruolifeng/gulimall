package cn.rlfit.gulimall.product.controller;

import cn.rlfit.gulimall.product.domain.PmsBrand;
import cn.rlfit.gulimall.product.domain.PmsBrandPages;
import cn.rlfit.gulimall.product.service.PmsBrandService;
import cn.rlfit.gulimall.utils.resp.R;
import cn.rlfit.gulimall.valid.AddGroup;
import cn.rlfit.gulimall.valid.UpdateGroup;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 16/03/2024 1:29 PM
 */
@RestController()
@RequestMapping("/product/brand")
public class PmsBrandController {
    @Resource
    PmsBrandService pmsBrandService;

    /**
     * 获取品牌列表数据
     * @param pms 查询参数
     * @return 查询结果
     */
    @GetMapping("/list")
    public R getAllBrandList(@RequestParam Map<String, Object> pms) {
        PmsBrandPages list = pmsBrandService.getBrandAllList(pms);
        return R.ok().put("data", list);
    }

    /**
     * 新增加一条数据
     * @param pmsBrand 新增加的数据实体
     * @return 增加成功返回值
     */
    @PostMapping("/save")
    public R saveBrandData(@RequestBody PmsBrand pmsBrand) {
        pmsBrandService.saveBrand(pmsBrand);
        return R.ok();
    }

    /**
     * 更新品牌展示状态
     * @param pmsBrand 修改数据
     * @return 修改成功
     */
    @PostMapping("/update/status")
    public R updateBrandStatus(@RequestBody PmsBrand pmsBrand) {
        pmsBrandService.updateBrandStatus(pmsBrand);
        return R.ok();
    }

    /**
     * 更新品牌
     * @param pmsBrand 更新数据实体
     * @return 根性成功
     */
    @RequestMapping("/save")
    public R updateBrandData(@Validated({AddGroup.class}) @RequestBody PmsBrand pmsBrand) {
//        if (bindingResult.hasErrors()){
//            Map<String,String> map = new HashMap<>();
//            for (FieldError fieldError : bindingResult.getFieldErrors()) {
//                String defaultMessage = fieldError.getDefaultMessage();
//                String field = fieldError.getField();
//                map.put(defaultMessage, field);
//            }
//            // 有错误
//            return R.error(400,"提交的数据不合法").put("data",map);
//        }else {
//        }
        pmsBrandService.updateBrandData(pmsBrand);
        return R.ok();
        // 没有错误
    }

    /**
     * 通过id删除一个数据
     * @param ids id
     * @return 删除成功
     */
    @PostMapping("/delete")
    public R deleteBrand(@RequestBody Long[] ids) {
        pmsBrandService.deleteOneById(ids);
        return R.ok();
    }

    @GetMapping("/info/{id}")
    public R getOneInfo(@PathVariable Integer id) {
        PmsBrand oneInfo = pmsBrandService.getOneInfo(id);
        return R.ok().put("data", oneInfo);
    }

    @PostMapping("/update")
    public R updateInfo(@Validated({UpdateGroup.class}) @RequestBody PmsBrand pmsBrand) {
        pmsBrandService.updateInfo(pmsBrand);
        return R.ok();
    }
}
