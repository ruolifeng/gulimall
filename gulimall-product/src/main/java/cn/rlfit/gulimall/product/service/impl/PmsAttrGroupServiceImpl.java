package cn.rlfit.gulimall.product.service.impl;

import cn.rlfit.gulimall.product.domain.PageUtils;
import cn.rlfit.gulimall.product.domain.PmsAttrGroup;
import cn.rlfit.gulimall.product.mapper.PmsAttrGroupMapper;
import cn.rlfit.gulimall.product.service.PmsAttrGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 19/03/2024 11:10 AM
 */
@Service
public class PmsAttrGroupServiceImpl implements PmsAttrGroupService {
    @Autowired
    PmsAttrGroupMapper pmsAttrGroupMapper;

    /**
     * 在page中还需还封装总页数，每一大小，当前页，总记录数
     * @param pms 查询参数
     * @param catalogId 目录id
     * @return 查询结果
     */
    @Override
    public PageUtils<PmsAttrGroup> queryPage(Map<String, Object> pms, Long catalogId) {
        Integer page = null;
        Integer size = null;
        String key = null;
        if (pms.get("page") != null)
            page = Integer.parseInt((String) pms.get("page"));
        if (pms.get("size") != null)
            size = Integer.parseInt((String) pms.get("size"));
        if (pms.get("key") != null)
            key = (String) pms.get("key");
        Integer count = pmsAttrGroupMapper.getCount();
        // 查询条件中可能携带key，key可以是当前组id，也可以是组名的关键字，所以需要使用模糊查询
        List<PmsAttrGroup> catalogInfo = pmsAttrGroupMapper.queryPage(key, catalogId, page, size);
        PageUtils<PmsAttrGroup> pageUtils = new PageUtils<>();
        pageUtils.setData(catalogInfo);
        pageUtils.setPageSize(size);
        if (pms.get("size") != null)
            pageUtils.setTotalPage(count / size);
        pageUtils.setCurrentPage(page);
        pageUtils.setTotalCount(count);
        return pageUtils;
    }

    @Override
    public void save(PmsAttrGroup pmsAttrGroup) {
        pmsAttrGroupMapper.insertSelective(pmsAttrGroup);
    }

    @Override
    public void delete(Long[] id) {
        Arrays.stream(id).distinct().forEach(x -> pmsAttrGroupMapper.deleteByPrimaryKey(x));
    }
}
