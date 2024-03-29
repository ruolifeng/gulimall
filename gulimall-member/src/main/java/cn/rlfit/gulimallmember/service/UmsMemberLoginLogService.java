package cn.rlfit.gulimallmember.service;

import cn.rlfit.gulimallmember.domain.UmsMemberLoginLog;
import java.util.List;
    /**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 29/03/2024 1:56 PM
 */
public interface UmsMemberLoginLogService{

    int deleteByPrimaryKey(Long id);

    int insert(UmsMemberLoginLog record);

    int insertSelective(UmsMemberLoginLog record);

    UmsMemberLoginLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UmsMemberLoginLog record);

    int updateByPrimaryKey(UmsMemberLoginLog record);

    int batchInsert(List<UmsMemberLoginLog> list);

}
