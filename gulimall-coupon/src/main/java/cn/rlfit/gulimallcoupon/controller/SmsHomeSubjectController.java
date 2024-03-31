package cn.rlfit.gulimallcoupon.controller;
import cn.rlfit.gulimallcoupon.domain.SmsHomeSubject;
import cn.rlfit.gulimallcoupon.service.impl.SmsHomeSubjectServiceImpl;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;

/**
* 首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】(sms_home_subject)表控制层
*
* @author xxxxx
*/
@RestController
@RequestMapping("/sms_home_subject")
public class SmsHomeSubjectController {
/**
* 服务对象
*/
    @Autowired
    private SmsHomeSubjectServiceImpl smsHomeSubjectServiceImpl;

    /**
    * 通过主键查询单条数据
    *
    * @param id 主键
    * @return 单条数据
    */
    @GetMapping("selectOne")
    public SmsHomeSubject selectOne(Long id) {
    return smsHomeSubjectServiceImpl.selectByPrimaryKey(id);
    }

}
