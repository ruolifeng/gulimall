package cn.rlfit.gulimall.product.controller;

import cn.rlfit.gulimall.product.domain.PmsCategory;
import cn.rlfit.gulimall.product.service.PmsCategoryService;
import cn.rlfit.gulimall.utils.resp.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 14/03/2024 2:27 PM
 */
@RestController
@RequestMapping("/product/category")
public class PmsCategoryController {
    @Resource
    PmsCategoryService pmsCategoryService;

    /**
     * 获取所有的分类数据，将其封装成树形结构返回
     * @return 删除成功数据
     */
    @GetMapping("/list")
    public R getAllCategoryToTree(){
        List<PmsCategory> list =  pmsCategoryService.getAllCategoryToTree();
        return R.ok().put("data", list);
    }

    /**
     * 删除返回的catIds数组中的每一条数据
     * @param catIds id数据
     * @return 返回删除成功数据
     */
    @PostMapping("/delete")
    public R delete(@RequestBody Long[] catIds){
        // 检查当前需要删除的菜单是否被别的地方使用
        pmsCategoryService.deleteMenusByCatIds(Arrays.asList(catIds));
        return null;
    }
}
