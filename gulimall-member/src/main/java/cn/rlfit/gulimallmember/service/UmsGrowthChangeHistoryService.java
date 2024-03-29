package cn.rlfit.gulimallmember.service;

import cn.rlfit.gulimallmember.domain.UmsGrowthChangeHistory;
import java.util.List;
    /**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 29/03/2024 1:55 PM
 */
public interface UmsGrowthChangeHistoryService{

    int deleteByPrimaryKey(Long id);

    int insert(UmsGrowthChangeHistory record);

    int insertSelective(UmsGrowthChangeHistory record);

    UmsGrowthChangeHistory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UmsGrowthChangeHistory record);

    int updateByPrimaryKey(UmsGrowthChangeHistory record);

    int batchInsert(List<UmsGrowthChangeHistory> list);

}
