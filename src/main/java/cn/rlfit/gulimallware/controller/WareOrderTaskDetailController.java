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
import cn.rlfit.gulimallware.entity.WareOrderTaskDetail;
import cn.rlfit.gulimallware.service.WareOrderTaskDetailService;
import org.springframework.web.bind.annotation.RestController;
import java.io.Serializable;
import java.util.List;

/**
 * 库存工作单 控制层。
 *
 * @author ruolifeng
 * @since 2024-04-04 18:02:29
 */
@RestController
@RequestMapping("/wareOrderTaskDetail")
public class WareOrderTaskDetailController {

    @Autowired
    private WareOrderTaskDetailService wareOrderTaskDetailService;

    /**
     * 添加库存工作单。
     *
     * @param wareOrderTaskDetail 库存工作单
     * @return {@code true} 添加成功，{@code false} 添加失败
     */
    @PostMapping("save")
    public boolean save(@RequestBody WareOrderTaskDetail wareOrderTaskDetail) {
        return wareOrderTaskDetailService.save(wareOrderTaskDetail);
    }

    /**
     * 根据主键删除库存工作单。
     *
     * @param id 主键
     * @return {@code true} 删除成功，{@code false} 删除失败
     */
    @DeleteMapping("remove/{id}")
    public boolean remove(@PathVariable Serializable id) {
        return wareOrderTaskDetailService.removeById(id);
    }

    /**
     * 根据主键更新库存工作单。
     *
     * @param wareOrderTaskDetail 库存工作单
     * @return {@code true} 更新成功，{@code false} 更新失败
     */
    @PutMapping("update")
    public boolean update(@RequestBody WareOrderTaskDetail wareOrderTaskDetail) {
        return wareOrderTaskDetailService.updateById(wareOrderTaskDetail);
    }

    /**
     * 查询所有库存工作单。
     *
     * @return 所有数据
     */
    @GetMapping("list")
    public List<WareOrderTaskDetail> list() {
        return wareOrderTaskDetailService.list();
    }

    /**
     * 根据库存工作单主键获取详细信息。
     *
     * @param id 库存工作单主键
     * @return 库存工作单详情
     */
    @GetMapping("getInfo/{id}")
    public WareOrderTaskDetail getInfo(@PathVariable Serializable id) {
        return wareOrderTaskDetailService.getById(id);
    }

    /**
     * 分页查询库存工作单。
     *
     * @param page 分页对象
     * @return 分页对象
     */
    @GetMapping("page")
    public Page<WareOrderTaskDetail> page(Page<WareOrderTaskDetail> page) {
        return wareOrderTaskDetailService.page(page);
    }

}
