package cn.rlfit.gulimallmember.service.impl;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import cn.rlfit.gulimallmember.mapper.UmsMemberCollectSubjectMapper;
import cn.rlfit.gulimallmember.domain.UmsMemberCollectSubject;
import cn.rlfit.gulimallmember.service.UmsMemberCollectSubjectService;
/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 29/03/2024 1:55 PM
 */
@Service
public class UmsMemberCollectSubjectServiceImpl implements UmsMemberCollectSubjectService{

    @Autowired
    private UmsMemberCollectSubjectMapper umsMemberCollectSubjectMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return umsMemberCollectSubjectMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(UmsMemberCollectSubject record) {
        return umsMemberCollectSubjectMapper.insert(record);
    }

    @Override
    public int insertSelective(UmsMemberCollectSubject record) {
        return umsMemberCollectSubjectMapper.insertSelective(record);
    }

    @Override
    public UmsMemberCollectSubject selectByPrimaryKey(Long id) {
        return umsMemberCollectSubjectMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(UmsMemberCollectSubject record) {
        return umsMemberCollectSubjectMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UmsMemberCollectSubject record) {
        return umsMemberCollectSubjectMapper.updateByPrimaryKey(record);
    }

    @Override
    public int batchInsert(List<UmsMemberCollectSubject> list) {
        return umsMemberCollectSubjectMapper.batchInsert(list);
    }

}
