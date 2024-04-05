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
import cn.rlfit.gulimallware.entity.WareSku;
import cn.rlfit.gulimallware.service.WareSkuService;
import org.springframework.web.bind.annotation.RestController;
import java.io.Serializable;
import java.util.List;

/**
 * 商品库存 控制层。
 *
 * @author ruolifeng
 * @since 2024-04-04 18:02:29
 */
@RestController
@RequestMapping("/wareSku")
public class WareSkuController {

    @Autowired
    private WareSkuService wareSkuService;

    /**
     * 添加商品库存。
     *
     * @param wareSku 商品库存
     * @return {@code true} 添加成功，{@code false} 添加失败
     */
    @PostMapping("save")
    public boolean save(@RequestBody WareSku wareSku) {
        return wareSkuService.save(wareSku);
    }

    /**
     * 根据主键删除商品库存。
     *
     * @param id 主键
     * @return {@code true} 删除成功，{@code false} 删除失败
     */
    @DeleteMapping("remove/{id}")
    public boolean remove(@PathVariable Serializable id) {
        return wareSkuService.removeById(id);
    }

    /**
     * 根据主键更新商品库存。
     *
     * @param wareSku 商品库存
     * @return {@code true} 更新成功，{@code false} 更新失败
     */
    @PutMapping("update")
    public boolean update(@RequestBody WareSku wareSku) {
        return wareSkuService.updateById(wareSku);
    }

    /**
     * 查询所有商品库存。
     *
     * @return 所有数据
     */
    @GetMapping("list")
    public List<WareSku> list() {
        return wareSkuService.list();
    }

    /**
     * 根据商品库存主键获取详细信息。
     *
     * @param id 商品库存主键
     * @return 商品库存详情
     */
    @GetMapping("getInfo/{id}")
    public WareSku getInfo(@PathVariable Serializable id) {
        return wareSkuService.getById(id);
    }

    /**
     * 分页查询商品库存。
     *
     * @param page 分页对象
     * @return 分页对象
     */
    @GetMapping("page")
    public Page<WareSku> page(Page<WareSku> page) {
        return wareSkuService.page(page);
    }

}
