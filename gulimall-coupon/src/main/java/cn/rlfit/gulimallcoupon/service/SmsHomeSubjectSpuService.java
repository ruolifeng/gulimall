package cn.rlfit.gulimallcoupon.service;

import java.util.List;
import cn.rlfit.gulimallcoupon.domain.SmsHomeSubjectSpu;
    /**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 31/03/2024 1:10 PM
 */
public interface SmsHomeSubjectSpuService{

    int deleteByPrimaryKey(Long id);

    int insert(SmsHomeSubjectSpu record);

    int insertSelective(SmsHomeSubjectSpu record);

    SmsHomeSubjectSpu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SmsHomeSubjectSpu record);

    int updateByPrimaryKey(SmsHomeSubjectSpu record);

    int batchInsert(List<SmsHomeSubjectSpu> list);

}
