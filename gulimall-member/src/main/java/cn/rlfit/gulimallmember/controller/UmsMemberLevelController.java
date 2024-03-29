package cn.rlfit.gulimallmember.controller;

import cn.rlfit.gulimall.utils.resp.Page;
import cn.rlfit.gulimall.utils.resp.R;
import cn.rlfit.gulimallmember.domain.UmsMemberLevel;
import cn.rlfit.gulimallmember.service.UmsMemberLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 29/03/2024 3:56 PM
 */
@RestController
@RequestMapping("/member/memberlevel")
public class UmsMemberLevelController {
    @Autowired
    UmsMemberLevelService umsMemberLevelService;
    @GetMapping("/list")
    public R memberLevel(@RequestParam Map<String,Object> pms){
        Page<List<UmsMemberLevel>> listPage = umsMemberLevelService.selectAllMemberLevel(pms);
        return R.ok().put("data",listPage);
    }

    @PostMapping("/save")
    public R save(@RequestBody UmsMemberLevel umsMemberLevel){
        umsMemberLevelService.save(umsMemberLevel);
        return R.ok();
    }

    @GetMapping("/info/{id}")
    public R selectInfo(@PathVariable long id){
        UmsMemberLevel umsMemberLevel = umsMemberLevelService.selectByPrimaryKey(id);
        return R.ok().put("data", umsMemberLevel);
    }

    @PostMapping("/update")
    public R update(@RequestBody UmsMemberLevel umsMemberLevel){
        umsMemberLevelService.updateByPrimaryKeySelective(umsMemberLevel);
        return R.ok();
    }

    @PostMapping("/delete")
    public R delete(@RequestBody long[] ids){
        umsMemberLevelService.deleteBatch(ids);
        return R.ok();
    }
}
