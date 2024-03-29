package cn.rlfit.gulimallmember.controller;

import cn.rlfit.gulimall.utils.resp.Page;
import cn.rlfit.gulimallmember.domain.UmsMember;
import cn.rlfit.gulimallmember.service.UmsMemberService;
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
 * @date: 29/03/2024 2:24 PM
 */
@RestController()
@RequestMapping("/member/member")
public class UmsMemberController {
    @Autowired
    UmsMemberService umsMemberService;

    @GetMapping("/list")
    public Page<List<UmsMember>> list(@RequestParam Map<String,Object> pms){
       return umsMemberService.selectAllOfPage(pms);
    }
}
