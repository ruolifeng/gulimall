package cn.rlfit.gulimall.product.service.impl;

import cn.rlfit.gulimall.product.domain.PmsCategory;
import cn.rlfit.gulimall.product.mapper.PmsCategoryMapper;
import cn.rlfit.gulimall.product.service.PmsCategoryService;
import com.alibaba.nacos.common.utils.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

    @Transactional
    @Override
    public void deleteMenusByCatIds(List<Long> list) {
        list.stream().distinct().forEach(catId -> pmsCategoryMapper.deleteMenusByCatIds(catId));
    }

    @Override
    public void save(PmsCategory category) {
        pmsCategoryMapper.insertSelective(category);
    }

    @Override
    public void updateCategory(PmsCategory category) {
        if (!Objects.isNull(category.getName()))
            pmsCategoryMapper.updateRelation(category.getCatId(),category.getName());
        pmsCategoryMapper.updateByPrimaryKeySelective(category);
    }

    @Override
    public PmsCategory getOneInfoById(Long catId) {
        return pmsCategoryMapper.selectByPrimaryKey(catId);
    }

    @Transactional
    @Override
    public void updateBatchById(PmsCategory[] categories) {
        Arrays.stream(categories).distinct().forEach(x -> pmsCategoryMapper.updateByPrimaryKeySelective(x));
    }

    @Override
    public Long[] findCatelongPath(Long id) {
        List<Long> paths = new ArrayList<>();
        // 先查询出当前分类，如果还存在父分类的话继续向上查询
        List<Long> parentPaths = findParentPaths(id, paths);
        Collections.reverse(parentPaths);
        return  parentPaths.toArray(new Long[parentPaths.size()]);
    }

    /**
     * 递归查找
     * @param id 父节点id
     * @param paths 收集数据
     * @return 返回最终数据
     */
    private List<Long> findParentPaths(Long id, List<Long> paths) {
        paths.add(id);
        PmsCategory pmsCategory = pmsCategoryMapper.selectByPrimaryKey(id);
        if (pmsCategory.getParentCid() != 0) {
            findParentPaths(pmsCategory.getParentCid(), paths);
        }
        return paths;
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
