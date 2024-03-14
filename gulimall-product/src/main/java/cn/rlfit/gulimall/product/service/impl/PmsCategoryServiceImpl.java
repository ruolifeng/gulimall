package cn.rlfit.gulimall.product.service.impl;

import cn.rlfit.gulimall.product.domain.PmsCategory;
import cn.rlfit.gulimall.product.mapper.PmsCategoryMapper;
import cn.rlfit.gulimall.product.service.PmsCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 14/03/2024 2:29 PM
 */
@Service
public class PmsCategoryServiceImpl implements PmsCategoryService {
    @Autowired
    PmsCategoryMapper pmsCategoryMapper;

    @Override
    public List<PmsCategory> getAllCategoryToTree() {
        // 查询出所有数据
        List<PmsCategory> list = pmsCategoryMapper.getAllCategory();

        // 组装成树形结构
        List<PmsCategory> level1Menu = list.stream().filter(menu -> menu.getParentCid() == 0)
                .peek((parent) -> parent.setChildren(getChildrenMenu(parent, list)))
                .sorted((menu1, menu2) -> (menu1.getSort() == null ? 0 : menu1.getSort()) - (menu2.getSort() == null ? 0 : menu2.getSort()))
                .collect(Collectors.toList());
        return level1Menu;
    }

    /**
     *  查询子节点
     * @param parentMenu 父节点
     * @param allMenu 全部节点
     * @return 字节点
     */
    private List<PmsCategory> getChildrenMenu(PmsCategory parentMenu, List<PmsCategory> allMenu) {
        return allMenu.stream()
                .filter(menu -> menu.getParentCid()
                        .equals(parentMenu.getCatId()))
                .peek(menu -> menu.setChildren(getChildrenMenu(menu, allMenu)))
                .sorted((menu1, menu2) -> (menu1.getSort() == null ? 0 : menu1.getSort()) - (menu2.getSort() == null ? 0 : menu2.getSort()))
                .collect(Collectors.toList());
    }
}
