package cn.rlfit.gulimallmember.service.impl;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import cn.rlfit.gulimallmember.domain.UmsMemberStatisticsInfo;
import cn.rlfit.gulimallmember.mapper.UmsMemberStatisticsInfoMapper;
import cn.rlfit.gulimallmember.service.UmsMemberStatisticsInfoService;
/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 29/03/2024 1:56 PM
 */
@Service
public class UmsMemberStatisticsInfoServiceImpl implements UmsMemberStatisticsInfoService{

    @Autowired
    private UmsMemberStatisticsInfoMapper umsMemberStatisticsInfoMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return umsMemberStatisticsInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(UmsMemberStatisticsInfo record) {
        return umsMemberStatisticsInfoMapper.insert(record);
    }

    @Override
    public int insertSelective(UmsMemberStatisticsInfo record) {
        return umsMemberStatisticsInfoMapper.insertSelective(record);
    }

    @Override
    public UmsMemberStatisticsInfo selectByPrimaryKey(Long id) {
        return umsMemberStatisticsInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(UmsMemberStatisticsInfo record) {
        return umsMemberStatisticsInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UmsMemberStatisticsInfo record) {
        return umsMemberStatisticsInfoMapper.updateByPrimaryKey(record);
    }

    @Override
    public int batchInsert(List<UmsMemberStatisticsInfo> list) {
        return umsMemberStatisticsInfoMapper.batchInsert(list);
    }

}
