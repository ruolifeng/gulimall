package cn.rlfit.gulimallmember.service.impl;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import cn.rlfit.gulimallmember.mapper.UmsMemberReceiveAddressMapper;
import cn.rlfit.gulimallmember.domain.UmsMemberReceiveAddress;
import cn.rlfit.gulimallmember.service.UmsMemberReceiveAddressService;
/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 29/03/2024 1:56 PM
 */
@Service
public class UmsMemberReceiveAddressServiceImpl implements UmsMemberReceiveAddressService{

    @Autowired
    private UmsMemberReceiveAddressMapper umsMemberReceiveAddressMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return umsMemberReceiveAddressMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(UmsMemberReceiveAddress record) {
        return umsMemberReceiveAddressMapper.insert(record);
    }

    @Override
    public int insertSelective(UmsMemberReceiveAddress record) {
        return umsMemberReceiveAddressMapper.insertSelective(record);
    }

    @Override
    public UmsMemberReceiveAddress selectByPrimaryKey(Long id) {
        return umsMemberReceiveAddressMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(UmsMemberReceiveAddress record) {
        return umsMemberReceiveAddressMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UmsMemberReceiveAddress record) {
        return umsMemberReceiveAddressMapper.updateByPrimaryKey(record);
    }

    @Override
    public int batchInsert(List<UmsMemberReceiveAddress> list) {
        return umsMemberReceiveAddressMapper.batchInsert(list);
    }

}
