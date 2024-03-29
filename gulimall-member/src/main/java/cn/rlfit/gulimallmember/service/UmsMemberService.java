package cn.rlfit.gulimallmember.service;

import cn.rlfit.gulimall.utils.resp.Page;
import cn.rlfit.gulimallmember.domain.UmsMember;

import java.util.List;
import java.util.Map;

/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 29/03/2024 1:52 PM
 */
public interface UmsMemberService {

    int deleteByPrimaryKey(Long id);

    int insert(UmsMember record);

    int insertSelective(UmsMember record);

    UmsMember selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UmsMember record);

    int updateByPrimaryKey(UmsMember record);

    int batchInsert(List<UmsMember> list);

    Page<List<UmsMember>> selectAllOfPage(Map<String, Object> pms);
}
