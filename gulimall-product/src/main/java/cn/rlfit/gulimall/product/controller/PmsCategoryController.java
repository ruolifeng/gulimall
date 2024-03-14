package cn.rlfit.gulimall.product.controller;

import cn.rlfit.gulimall.product.domain.PmsCategory;
import cn.rlfit.gulimall.product.service.PmsCategoryService;
import cn.rlfit.gulimall.utils.resp.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 14/03/2024 2:27 PM
 */
@RestController
@RequestMapping("/product/category")
public class PmsCategoryController {
    @Autowired
    PmsCategoryService pmsCategoryService;

    /**
     * 获取所有的分类数据，将其封装成树形结构返回
     * @return
     */
    @GetMapping("/list")
    public R getAllCategoryToTree(){
        List<PmsCategory> list =  pmsCategoryService.getAllCategoryToTree();
        return R.ok().put("data", list);
    }
}
