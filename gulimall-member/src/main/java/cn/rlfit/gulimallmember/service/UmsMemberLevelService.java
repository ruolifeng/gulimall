package cn.rlfit.gulimallmember.service;

import java.util.List;
import cn.rlfit.gulimallmember.domain.UmsMemberLevel;
    /**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 29/03/2024 1:55 PM
 */
public interface UmsMemberLevelService{

    int deleteByPrimaryKey(Long id);

    int insert(UmsMemberLevel record);

    int insertSelective(UmsMemberLevel record);

    UmsMemberLevel selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UmsMemberLevel record);

    int updateByPrimaryKey(UmsMemberLevel record);

    int batchInsert(List<UmsMemberLevel> list);

}
