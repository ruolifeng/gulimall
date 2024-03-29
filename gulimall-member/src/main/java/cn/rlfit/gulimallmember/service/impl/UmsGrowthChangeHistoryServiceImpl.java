package cn.rlfit.gulimallmember.service.impl;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import cn.rlfit.gulimallmember.mapper.UmsGrowthChangeHistoryMapper;
import cn.rlfit.gulimallmember.domain.UmsGrowthChangeHistory;
import java.util.List;
import cn.rlfit.gulimallmember.service.UmsGrowthChangeHistoryService;
/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 29/03/2024 1:55 PM
 */
@Service
public class UmsGrowthChangeHistoryServiceImpl implements UmsGrowthChangeHistoryService{

    @Autowired
    private UmsGrowthChangeHistoryMapper umsGrowthChangeHistoryMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return umsGrowthChangeHistoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(UmsGrowthChangeHistory record) {
        return umsGrowthChangeHistoryMapper.insert(record);
    }

    @Override
    public int insertSelective(UmsGrowthChangeHistory record) {
        return umsGrowthChangeHistoryMapper.insertSelective(record);
    }

    @Override
    public UmsGrowthChangeHistory selectByPrimaryKey(Long id) {
        return umsGrowthChangeHistoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(UmsGrowthChangeHistory record) {
        return umsGrowthChangeHistoryMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UmsGrowthChangeHistory record) {
        return umsGrowthChangeHistoryMapper.updateByPrimaryKey(record);
    }

    @Override
    public int batchInsert(List<UmsGrowthChangeHistory> list) {
        return umsGrowthChangeHistoryMapper.batchInsert(list);
    }

}
