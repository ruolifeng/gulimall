package cn.rlfit.gulimallmember.service;

import java.util.List;
import cn.rlfit.gulimallmember.domain.UmsMemberCollectSubject;
    /**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 29/03/2024 1:55 PM
 */
public interface UmsMemberCollectSubjectService{

    int deleteByPrimaryKey(Long id);

    int insert(UmsMemberCollectSubject record);

    int insertSelective(UmsMemberCollectSubject record);

    UmsMemberCollectSubject selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UmsMemberCollectSubject record);

    int updateByPrimaryKey(UmsMemberCollectSubject record);

    int batchInsert(List<UmsMemberCollectSubject> list);

}
