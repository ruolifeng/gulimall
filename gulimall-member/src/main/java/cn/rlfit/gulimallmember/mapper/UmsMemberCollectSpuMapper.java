package cn.rlfit.gulimallmember.mapper;

import cn.rlfit.gulimallmember.domain.UmsMemberCollectSpu;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 29/03/2024 1:55 PM
 */
@Mapper
public interface UmsMemberCollectSpuMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UmsMemberCollectSpu record);

    int insertSelective(UmsMemberCollectSpu record);

    UmsMemberCollectSpu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UmsMemberCollectSpu record);

    int updateByPrimaryKey(UmsMemberCollectSpu record);

    int batchInsert(@Param("list") List<UmsMemberCollectSpu> list);
}