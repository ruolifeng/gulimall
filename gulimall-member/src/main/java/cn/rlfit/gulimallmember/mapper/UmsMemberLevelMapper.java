package cn.rlfit.gulimallmember.mapper;

import cn.rlfit.gulimallmember.domain.UmsMemberLevel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 29/03/2024 1:55 PM
 */
@Mapper
public interface UmsMemberLevelMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UmsMemberLevel record);

    int insertSelective(UmsMemberLevel record);

    UmsMemberLevel selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UmsMemberLevel record);

    int updateByPrimaryKey(UmsMemberLevel record);

    int batchInsert(@Param("list") List<UmsMemberLevel> list);

    List<UmsMemberLevel> selectAllMemberLevel(Integer page, Integer size, String key);

    Integer seleCount();
}