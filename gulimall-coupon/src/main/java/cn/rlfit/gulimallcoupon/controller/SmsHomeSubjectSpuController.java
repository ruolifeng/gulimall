package cn.rlfit.gulimallcoupon.controller;
import cn.rlfit.gulimallcoupon.domain.SmsHomeSubjectSpu;
import cn.rlfit.gulimallcoupon.service.impl.SmsHomeSubjectSpuServiceImpl;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;

/**
* 专题商品(sms_home_subject_spu)表控制层
*
* @author xxxxx
*/
@RestController
@RequestMapping("/sms_home_subject_spu")
public class SmsHomeSubjectSpuController {
/**
* 服务对象
*/
    @Autowired
    private SmsHomeSubjectSpuServiceImpl smsHomeSubjectSpuServiceImpl;

    /**
    * 通过主键查询单条数据
    *
    * @param id 主键
    * @return 单条数据
    */
    @GetMapping("selectOne")
    public SmsHomeSubjectSpu selectOne(Long id) {
    return smsHomeSubjectSpuServiceImpl.selectByPrimaryKey(id);
    }

}
