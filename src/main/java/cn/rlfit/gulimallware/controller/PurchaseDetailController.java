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
import cn.rlfit.gulimallware.entity.PurchaseDetail;
import cn.rlfit.gulimallware.service.PurchaseDetailService;
import org.springframework.web.bind.annotation.RestController;
import java.io.Serializable;
import java.util.List;

/**
 *  控制层。
 *
 * @author ruolifeng
 * @since 2024-04-04 18:02:29
 */
@RestController
@RequestMapping("/purchaseDetail")
public class PurchaseDetailController {

    @Autowired
    private PurchaseDetailService purchaseDetailService;

    /**
     * 添加。
     *
     * @param purchaseDetail 
     * @return {@code true} 添加成功，{@code false} 添加失败
     */
    @PostMapping("save")
    public boolean save(@RequestBody PurchaseDetail purchaseDetail) {
        return purchaseDetailService.save(purchaseDetail);
    }

    /**
     * 根据主键删除。
     *
     * @param id 主键
     * @return {@code true} 删除成功，{@code false} 删除失败
     */
    @DeleteMapping("remove/{id}")
    public boolean remove(@PathVariable Serializable id) {
        return purchaseDetailService.removeById(id);
    }

    /**
     * 根据主键更新。
     *
     * @param purchaseDetail 
     * @return {@code true} 更新成功，{@code false} 更新失败
     */
    @PutMapping("update")
    public boolean update(@RequestBody PurchaseDetail purchaseDetail) {
        return purchaseDetailService.updateById(purchaseDetail);
    }

    /**
     * 查询所有。
     *
     * @return 所有数据
     */
    @GetMapping("list")
    public List<PurchaseDetail> list() {
        return purchaseDetailService.list();
    }

    /**
     * 根据主键获取详细信息。
     *
     * @param id 主键
     * @return 详情
     */
    @GetMapping("getInfo/{id}")
    public PurchaseDetail getInfo(@PathVariable Serializable id) {
        return purchaseDetailService.getById(id);
    }

    /**
     * 分页查询。
     *
     * @param page 分页对象
     * @return 分页对象
     */
    @GetMapping("page")
    public Page<PurchaseDetail> page(Page<PurchaseDetail> page) {
        return purchaseDetailService.page(page);
    }

}
