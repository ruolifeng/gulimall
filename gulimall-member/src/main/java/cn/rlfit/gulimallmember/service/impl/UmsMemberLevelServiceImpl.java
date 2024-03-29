package cn.rlfit.gulimallmember.service.impl;

import cn.rlfit.gulimall.utils.resp.Page;
import cn.rlfit.gulimallmember.domain.UmsMemberLevel;
import cn.rlfit.gulimallmember.mapper.UmsMemberLevelMapper;
import cn.rlfit.gulimallmember.service.UmsMemberLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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

    @Override
    public Page<List<UmsMemberLevel>> selectAllMemberLevel(Map<String, Object> pms) {
        Integer page = null;
        Integer size = null;
        String key = null;
        Page<List<UmsMemberLevel>> data = new Page<>();
        if (!Objects.isNull(pms.get("page")))
            page = Integer.valueOf((String) pms.get("page"));
        if (!Objects.isNull(pms.get("limit")))
            size = Integer.valueOf((String) pms.get("limit"));
        if (!Objects.isNull(pms.get("key")))
            key = (String) pms.get("key");
        List<UmsMemberLevel> memberLevel = umsMemberLevelMapper.selectAllMemberLevel(page, size, key);
        Integer count = umsMemberLevelMapper.seleCount();
        data.setData(memberLevel);
        data.setTotalCount(count);
        data.setCurrentPage(page);
        if (!Objects.isNull(pms.get("limit")))
            data.setTotalPage(count / size);
        return data;
    }

    @Override
    public void save(UmsMemberLevel umsMemberLevel) {
        umsMemberLevelMapper.insertSelective(umsMemberLevel);
    }

    @Override
    public void deleteBatch(long[] ids) {
        Arrays.stream(ids).distinct().forEach(x->umsMemberLevelMapper.deleteByPrimaryKey(x));
    }

}
