package cn.rlfit.gulimallmember.service;

import java.util.List;
import cn.rlfit.gulimallmember.domain.UmsMemberStatisticsInfo;
    /**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 29/03/2024 1:56 PM
 */
public interface UmsMemberStatisticsInfoService{

    int deleteByPrimaryKey(Long id);

    int insert(UmsMemberStatisticsInfo record);

    int insertSelective(UmsMemberStatisticsInfo record);

    UmsMemberStatisticsInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UmsMemberStatisticsInfo record);

    int updateByPrimaryKey(UmsMemberStatisticsInfo record);

    int batchInsert(List<UmsMemberStatisticsInfo> list);

}
