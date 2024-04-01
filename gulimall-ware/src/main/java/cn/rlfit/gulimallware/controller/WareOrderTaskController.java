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
import cn.rlfit.gulimallware.entity.WareOrderTask;
import cn.rlfit.gulimallware.service.WareOrderTaskService;
import org.springframework.web.bind.annotation.RestController;
import java.io.Serializable;
import java.util.List;

/**
 * 库存工作单 控制层。
 *
 * @author ruolifeng
 * @since 2024-04-01 12:37:31
 */
@RestController
@RequestMapping("/wareOrderTask")
public class WareOrderTaskController {

    @Autowired
    private WareOrderTaskService wareOrderTaskService;

    /**
     * 添加库存工作单。
     *
     * @param wareOrderTask 库存工作单
     * @return {@code true} 添加成功，{@code false} 添加失败
     */
    @PostMapping("save")
    public boolean save(@RequestBody WareOrderTask wareOrderTask) {
        return wareOrderTaskService.save(wareOrderTask);
    }

    /**
     * 根据主键删除库存工作单。
     *
     * @param id 主键
     * @return {@code true} 删除成功，{@code false} 删除失败
     */
    @DeleteMapping("remove/{id}")
    public boolean remove(@PathVariable Serializable id) {
        return wareOrderTaskService.removeById(id);
    }

    /**
     * 根据主键更新库存工作单。
     *
     * @param wareOrderTask 库存工作单
     * @return {@code true} 更新成功，{@code false} 更新失败
     */
    @PutMapping("update")
    public boolean update(@RequestBody WareOrderTask wareOrderTask) {
        return wareOrderTaskService.updateById(wareOrderTask);
    }

    /**
     * 查询所有库存工作单。
     *
     * @return 所有数据
     */
    @GetMapping("list")
    public List<WareOrderTask> list() {
        return wareOrderTaskService.list();
    }

    /**
     * 根据库存工作单主键获取详细信息。
     *
     * @param id 库存工作单主键
     * @return 库存工作单详情
     */
    @GetMapping("getInfo/{id}")
    public WareOrderTask getInfo(@PathVariable Serializable id) {
        return wareOrderTaskService.getById(id);
    }

    /**
     * 分页查询库存工作单。
     *
     * @param page 分页对象
     * @return 分页对象
     */
    @GetMapping("page")
    public Page<WareOrderTask> page(Page<WareOrderTask> page) {
        return wareOrderTaskService.page(page);
    }

}
