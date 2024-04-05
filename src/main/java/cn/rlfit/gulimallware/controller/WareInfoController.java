package cn.rlfit.gulimallware.controller;

import com.mybatisflex.core.paginate.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import cn.rlfit.gulimallware.entity.WareInfo;
import cn.rlfit.gulimallware.service.WareInfoService;
import org.springframework.web.bind.annotation.RestController;
import java.io.Serializable;
import java.util.List;

/**
 * 仓库信息 控制层。
 *
 * @author ruolifeng
 * @since 2024-04-04 18:02:29
 */
@RestController
@RequestMapping("/wareInfo")
public class WareInfoController {

    @Autowired
    private WareInfoService wareInfoService;

    /**
     * 添加仓库信息。
     *
     * @param wareInfo 仓库信息
     * @return {@code true} 添加成功，{@code false} 添加失败
     */
    @PostMapping("save")
    public boolean save(@RequestBody WareInfo wareInfo) {
        return wareInfoService.save(wareInfo);
    }

    /**
     * 根据主键删除仓库信息。
     *
     * @param id 主键
     * @return {@code true} 删除成功，{@code false} 删除失败
     */
    @DeleteMapping("remove/{id}")
    public boolean remove(@PathVariable Serializable id) {
        return wareInfoService.removeById(id);
    }

    /**
     * 根据主键更新仓库信息。
     *
     * @param wareInfo 仓库信息
     * @return {@code true} 更新成功，{@code false} 更新失败
     */
    @PutMapping("update")
    public boolean update(@RequestBody WareInfo wareInfo) {
        return wareInfoService.updateById(wareInfo);
    }

    /**
     * 查询所有仓库信息。
     *
     * @return 所有数据
     */
    @GetMapping("list")
    public List<WareInfo> list() {
        return wareInfoService.list();
    }

    /**
     * 根据仓库信息主键获取详细信息。
     *
     * @param id 仓库信息主键
     * @return 仓库信息详情
     */
    @GetMapping("getInfo/{id}")
    public WareInfo getInfo(@PathVariable Serializable id) {
        return wareInfoService.getById(id);
    }

    /**
     * 分页查询仓库信息。
     *
     * @param page 分页对象
     * @return 分页对象
     */
    @GetMapping("page")
    public Page<WareInfo> page(Page<WareInfo> page) {
        return wareInfoService.page(page);
    }

}
