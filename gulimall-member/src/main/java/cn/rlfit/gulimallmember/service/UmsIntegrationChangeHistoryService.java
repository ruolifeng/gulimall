package cn.rlfit.gulimallmember.service;

import java.util.List;
import cn.rlfit.gulimallmember.domain.UmsIntegrationChangeHistory;
    /**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 29/03/2024 1:55 PM
 */
public interface UmsIntegrationChangeHistoryService{

    int deleteByPrimaryKey(Long id);

    int insert(UmsIntegrationChangeHistory record);

    int insertSelective(UmsIntegrationChangeHistory record);

    UmsIntegrationChangeHistory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UmsIntegrationChangeHistory record);

    int updateByPrimaryKey(UmsIntegrationChangeHistory record);

    int batchInsert(List<UmsIntegrationChangeHistory> list);

}
