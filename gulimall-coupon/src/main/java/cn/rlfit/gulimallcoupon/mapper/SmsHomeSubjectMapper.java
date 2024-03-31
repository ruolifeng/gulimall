package cn.rlfit.gulimallcoupon.mapper;

import cn.rlfit.gulimallcoupon.domain.SmsHomeSubject;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 31/03/2024 1:10 PM
 */
@Mapper
public interface SmsHomeSubjectMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SmsHomeSubject record);

    int insertSelective(SmsHomeSubject record);

    SmsHomeSubject selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SmsHomeSubject record);

    int updateByPrimaryKey(SmsHomeSubject record);

    int batchInsert(@Param("list") List<SmsHomeSubject> list);
}