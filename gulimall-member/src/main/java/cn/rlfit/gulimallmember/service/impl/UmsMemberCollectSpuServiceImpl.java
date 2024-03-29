package cn.rlfit.gulimallmember.service.impl;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import cn.rlfit.gulimallmember.domain.UmsMemberCollectSpu;
import java.util.List;
import cn.rlfit.gulimallmember.mapper.UmsMemberCollectSpuMapper;
import cn.rlfit.gulimallmember.service.UmsMemberCollectSpuService;
/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 29/03/2024 1:55 PM
 */
@Service
public class UmsMemberCollectSpuServiceImpl implements UmsMemberCollectSpuService{

    @Autowired
    private UmsMemberCollectSpuMapper umsMemberCollectSpuMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return umsMemberCollectSpuMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(UmsMemberCollectSpu record) {
        return umsMemberCollectSpuMapper.insert(record);
    }

    @Override
    public int insertSelective(UmsMemberCollectSpu record) {
        return umsMemberCollectSpuMapper.insertSelective(record);
    }

    @Override
    public UmsMemberCollectSpu selectByPrimaryKey(Long id) {
        return umsMemberCollectSpuMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(UmsMemberCollectSpu record) {
        return umsMemberCollectSpuMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UmsMemberCollectSpu record) {
        return umsMemberCollectSpuMapper.updateByPrimaryKey(record);
    }

    @Override
    public int batchInsert(List<UmsMemberCollectSpu> list) {
        return umsMemberCollectSpuMapper.batchInsert(list);
    }

}
