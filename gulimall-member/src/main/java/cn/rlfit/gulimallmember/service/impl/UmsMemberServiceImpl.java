package cn.rlfit.gulimallmember.service.impl;

import cn.rlfit.gulimall.utils.resp.Page;
import cn.rlfit.gulimallmember.domain.UmsMember;
import cn.rlfit.gulimallmember.mapper.UmsMemberMapper;
import cn.rlfit.gulimallmember.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 29/03/2024 1:52 PM
 */
@Service
public class UmsMemberServiceImpl implements UmsMemberService {

    @Autowired
    private UmsMemberMapper umsMemberMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return umsMemberMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(UmsMember record) {
        return umsMemberMapper.insert(record);
    }

    @Override
    public int insertSelective(UmsMember record) {
        return umsMemberMapper.insertSelective(record);
    }

    @Override
    public UmsMember selectByPrimaryKey(Long id) {
        return umsMemberMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(UmsMember record) {
        return umsMemberMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UmsMember record) {
        return umsMemberMapper.updateByPrimaryKey(record);
    }

    @Override
    public int batchInsert(List<UmsMember> list) {
        return umsMemberMapper.batchInsert(list);
    }

    /**
     * 分页查询所有的会员数据
     * @param pms 分页参数
     * @return 查询出的所有数据
     */
    @Override
    public Page<List<UmsMember>> selectAllOfPage(Map<String, Object> pms) {
        Integer page = null;
        Integer size = null;
        String key = null;
        Page<List<UmsMember>> data = new Page<>();
        if (!Objects.isNull(pms.get("page")))
            page = Integer.valueOf((String) pms.get("page"));
        if (!Objects.isNull(pms.get("limit")))
            size = Integer.valueOf((String) pms.get("limit"));
        if (!Objects.isNull(pms.get("key")))
            key = (String) pms.get("key");
        List<UmsMember> members = umsMemberMapper.selectAllOfPage(page, size, key);
        Integer count = umsMemberMapper.seleCount();
        data.setData(members);
        data.setTotalCount(count);
        data.setCurrentPage(page);
        if (!Objects.isNull(pms.get("limit")))
            data.setTotalPage(count / size);
        return data;
    }

}
