package cn.rlfit.gulimallcoupon.service;

import cn.rlfit.gulimallcoupon.domain.SmsHomeSubject;
import java.util.List;
    /**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 31/03/2024 1:10 PM
 */
public interface SmsHomeSubjectService{

    int deleteByPrimaryKey(Long id);

    int insert(SmsHomeSubject record);

    int insertSelective(SmsHomeSubject record);

    SmsHomeSubject selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SmsHomeSubject record);

    int updateByPrimaryKey(SmsHomeSubject record);

    int batchInsert(List<SmsHomeSubject> list);

}
