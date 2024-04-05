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
import cn.rlfit.gulimallware.entity.Purchase;
import cn.rlfit.gulimallware.service.PurchaseService;
import org.springframework.web.bind.annotation.RestController;
import java.io.Serializable;
import java.util.List;

/**
 * 采购信息 控制层。
 *
 * @author ruolifeng
 * @since 2024-04-04 18:02:29
 */
@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    /**
     * 添加采购信息。
     *
     * @param purchase 采购信息
     * @return {@code true} 添加成功，{@code false} 添加失败
     */
    @PostMapping("save")
    public boolean save(@RequestBody Purchase purchase) {
        return purchaseService.save(purchase);
    }

    /**
     * 根据主键删除采购信息。
     *
     * @param id 主键
     * @return {@code true} 删除成功，{@code false} 删除失败
     */
    @DeleteMapping("remove/{id}")
    public boolean remove(@PathVariable Serializable id) {
        return purchaseService.removeById(id);
    }

    /**
     * 根据主键更新采购信息。
     *
     * @param purchase 采购信息
     * @return {@code true} 更新成功，{@code false} 更新失败
     */
    @PutMapping("update")
    public boolean update(@RequestBody Purchase purchase) {
        return purchaseService.updateById(purchase);
    }

    /**
     * 查询所有采购信息。
     *
     * @return 所有数据
     */
    @GetMapping("list")
    public List<Purchase> list() {
        return purchaseService.list();
    }

    /**
     * 根据采购信息主键获取详细信息。
     *
     * @param id 采购信息主键
     * @return 采购信息详情
     */
    @GetMapping("getInfo/{id}")
    public Purchase getInfo(@PathVariable Serializable id) {
        return purchaseService.getById(id);
    }

    /**
     * 分页查询采购信息。
     *
     * @param page 分页对象
     * @return 分页对象
     */
    @GetMapping("page")
    public Page<Purchase> page(Page<Purchase> page) {
        return purchaseService.page(page);
    }

}
