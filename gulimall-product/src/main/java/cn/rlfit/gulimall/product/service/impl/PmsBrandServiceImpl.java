package cn.rlfit.gulimall.product.service.impl;

import cn.rlfit.gulimall.product.domain.PmsBrand;
import cn.rlfit.gulimall.product.domain.PmsBrandPages;
import cn.rlfit.gulimall.product.mapper.PmsBrandMapper;
import cn.rlfit.gulimall.product.service.PmsBrandService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 16/03/2024 1:32 PM
 */
@Service
public class PmsBrandServiceImpl implements PmsBrandService {
    @Resource
    PmsBrandMapper pmsBrandMapper;
    @Override
    public PmsBrandPages getBrandAllList(Map<String, Object> pms) {
        Integer page = Integer.parseInt((String) pms.get("page"));
        Integer size = Integer.parseInt((String) pms.get("limit"));
        String key = (String) pms.get("key");
        Integer count = pmsBrandMapper.getCount(key);
        PmsBrandPages pmsBrandPages = new PmsBrandPages();
        List<PmsBrand> brandAllList = pmsBrandMapper.getBrandAllList(page, size, key);
        pmsBrandPages.setData(brandAllList);
        pmsBrandPages.setTotalPage(count/page);
        return pmsBrandPages;
    }

    @Override
    public void saveBrand(PmsBrand pmsBrand) {
        pmsBrandMapper.insertSelective(pmsBrand);
    }

    @Override
    public void updateBrandStatus(PmsBrand pmsBrand) {
        pmsBrandMapper.updateByPrimaryKeySelective(pmsBrand);
    }

    @Override
    public void updateBrandData(PmsBrand pmsBrand) {
        pmsBrandMapper.updateByPrimaryKeySelective(pmsBrand);
    }

    @Override
    public void deleteOneById(Long[] ids) {
        Arrays.stream(ids).distinct().forEach(x->pmsBrandMapper.deleteByPrimaryKey(x));
    }

    @Override
    public PmsBrand getOneInfo(Integer id) {
        return pmsBrandMapper.selectByPrimaryKey(id.longValue());
    }
}
