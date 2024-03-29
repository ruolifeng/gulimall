package cn.rlfit.gulimallmember.service.impl;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import cn.rlfit.gulimallmember.domain.UmsMemberLoginLog;
import java.util.List;
import cn.rlfit.gulimallmember.mapper.UmsMemberLoginLogMapper;
import cn.rlfit.gulimallmember.service.UmsMemberLoginLogService;
/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 29/03/2024 1:56 PM
 */
@Service
public class UmsMemberLoginLogServiceImpl implements UmsMemberLoginLogService{

    @Autowired
    private UmsMemberLoginLogMapper umsMemberLoginLogMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return umsMemberLoginLogMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(UmsMemberLoginLog record) {
        return umsMemberLoginLogMapper.insert(record);
    }

    @Override
    public int insertSelective(UmsMemberLoginLog record) {
        return umsMemberLoginLogMapper.insertSelective(record);
    }

    @Override
    public UmsMemberLoginLog selectByPrimaryKey(Long id) {
        return umsMemberLoginLogMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(UmsMemberLoginLog record) {
        return umsMemberLoginLogMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UmsMemberLoginLog record) {
        return umsMemberLoginLogMapper.updateByPrimaryKey(record);
    }

    @Override
    public int batchInsert(List<UmsMemberLoginLog> list) {
        return umsMemberLoginLogMapper.batchInsert(list);
    }

}
