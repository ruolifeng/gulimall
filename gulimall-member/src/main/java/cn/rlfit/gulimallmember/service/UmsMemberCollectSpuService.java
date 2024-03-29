package cn.rlfit.gulimallmember.service;

import cn.rlfit.gulimallmember.domain.UmsMemberCollectSpu;
import java.util.List;
    /**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 29/03/2024 1:55 PM
 */
public interface UmsMemberCollectSpuService{

    int deleteByPrimaryKey(Long id);

    int insert(UmsMemberCollectSpu record);

    int insertSelective(UmsMemberCollectSpu record);

    UmsMemberCollectSpu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UmsMemberCollectSpu record);

    int updateByPrimaryKey(UmsMemberCollectSpu record);

    int batchInsert(List<UmsMemberCollectSpu> list);

}
