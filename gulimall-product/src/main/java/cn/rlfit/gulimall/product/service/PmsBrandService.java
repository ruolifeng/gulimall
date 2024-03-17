package cn.rlfit.gulimall.product.service;

import cn.rlfit.gulimall.product.domain.PmsBrand;
import cn.rlfit.gulimall.product.domain.PmsBrandPages;

import java.util.Map;

/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 16/03/2024 1:31 PM
 */
public interface PmsBrandService {

    PmsBrandPages getBrandAllList(Map<String, Object> pms);

    void saveBrand(PmsBrand pmsBrand);

    void updateBrandStatus(PmsBrand pmsBrand);

    void updateBrandData(PmsBrand pmsBrand);

    void deleteOneById(Long[] ids);

    PmsBrand getOneInfo(Integer id);

    void updateInfo(PmsBrand pmsBrand);
}
