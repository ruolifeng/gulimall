package cn.rlfit.gulimallmember.mapper;

import cn.rlfit.gulimallmember.domain.UmsMemberCollectSubject;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 29/03/2024 1:55 PM
 */
@Mapper
public interface UmsMemberCollectSubjectMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UmsMemberCollectSubject record);

    int insertSelective(UmsMemberCollectSubject record);

    UmsMemberCollectSubject selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UmsMemberCollectSubject record);

    int updateByPrimaryKey(UmsMemberCollectSubject record);

    int batchInsert(@Param("list") List<UmsMemberCollectSubject> list);
}