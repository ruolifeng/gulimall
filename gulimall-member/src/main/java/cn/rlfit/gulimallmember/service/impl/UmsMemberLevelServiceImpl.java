package cn.rlfit.gulimallmember.service.impl;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import cn.rlfit.gulimallmember.mapper.UmsMemberLevelMapper;
import cn.rlfit.gulimallmember.domain.UmsMemberLevel;
import cn.rlfit.gulimallmember.service.UmsMemberLevelService;
/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 29/03/2024 1:55 PM
 */
@Service
public class UmsMemberLevelServiceImpl implements UmsMemberLevelService{

    @Autowired
    private UmsMemberLevelMapper umsMemberLevelMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return umsMemberLevelMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(UmsMemberLevel record) {
        return umsMemberLevelMapper.insert(record);
    }

    @Override
    public int insertSelective(UmsMemberLevel record) {
        return umsMemberLevelMapper.insertSelective(record);
    }

    @Override
    public UmsMemberLevel selectByPrimaryKey(Long id) {
        return umsMemberLevelMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(UmsMemberLevel record) {
        return umsMemberLevelMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UmsMemberLevel record) {
        return umsMemberLevelMapper.updateByPrimaryKey(record);
    }

    @Override
    public int batchInsert(List<UmsMemberLevel> list) {
        return umsMemberLevelMapper.batchInsert(list);
    }

}
