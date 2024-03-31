package cn.rlfit.gulimallcoupon.mapper;

import cn.rlfit.gulimallcoupon.domain.SmsHomeSubjectSpu;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 31/03/2024 1:10 PM
 */
@Mapper
public interface SmsHomeSubjectSpuMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SmsHomeSubjectSpu record);

    int insertSelective(SmsHomeSubjectSpu record);

    SmsHomeSubjectSpu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SmsHomeSubjectSpu record);

    int updateByPrimaryKey(SmsHomeSubjectSpu record);

    int batchInsert(@Param("list") List<SmsHomeSubjectSpu> list);
}