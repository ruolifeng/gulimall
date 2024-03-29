package cn.rlfit.gulimallmember.controller;

import cn.rlfit.gulimall.utils.resp.Page;
import cn.rlfit.gulimall.utils.resp.R;
import cn.rlfit.gulimallmember.domain.UmsMemberLevel;
import cn.rlfit.gulimallmember.service.UmsMemberLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
