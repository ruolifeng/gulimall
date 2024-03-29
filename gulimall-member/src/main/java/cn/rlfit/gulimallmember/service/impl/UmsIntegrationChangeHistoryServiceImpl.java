package cn.rlfit.gulimallmember.service.impl;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import cn.rlfit.gulimallmember.mapper.UmsIntegrationChangeHistoryMapper;
import java.util.List;
import cn.rlfit.gulimallmember.domain.UmsIntegrationChangeHistory;
import cn.rlfit.gulimallmember.service.UmsIntegrationChangeHistoryService;
/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 29/03/2024 1:55 PM
 */
@Service
public class UmsIntegrationChangeHistoryServiceImpl implements UmsIntegrationChangeHistoryService{

    @Autowired
    private UmsIntegrationChangeHistoryMapper umsIntegrationChangeHistoryMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return umsIntegrationChangeHistoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(UmsIntegrationChangeHistory record) {
        return umsIntegrationChangeHistoryMapper.insert(record);
    }

    @Override
    public int insertSelective(UmsIntegrationChangeHistory record) {
        return umsIntegrationChangeHistoryMapper.insertSelective(record);
    }

    @Override
    public UmsIntegrationChangeHistory selectByPrimaryKey(Long id) {
        return umsIntegrationChangeHistoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(UmsIntegrationChangeHistory record) {
        return umsIntegrationChangeHistoryMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UmsIntegrationChangeHistory record) {
        return umsIntegrationChangeHistoryMapper.updateByPrimaryKey(record);
    }

    @Override
    public int batchInsert(List<UmsIntegrationChangeHistory> list) {
        return umsIntegrationChangeHistoryMapper.batchInsert(list);
    }

}
