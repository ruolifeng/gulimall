package cn.rlfit.gulimall.product.service;

import cn.rlfit.gulimall.product.vo.AttrVo;

import java.util.List;

/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 23/03/2024 1:02 PM
 */
public interface PmsAttrService {
    void saveAttr(AttrVo vo);

    List<AttrVo> getInfo(Integer catId);
}
