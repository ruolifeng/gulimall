package cn.rlfit.gulimallware.controller;

import cn.rlfit.gulimall.utils.resp.R;
import cn.rlfit.gulimallware.entity.WareSku;
import cn.rlfit.gulimallware.service.WareSkuService;
import com.mybatisflex.core.paginate.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.Map;

/**
 * 商品库存 控制层。
 *
 * @author ruolifeng
 * @since 2024-04-01 12:37:31
 */
@RestController
@RequestMapping("/ware/waresku")
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
//    @DeleteMapping("remove/{id}")
//    public boolean remove(@PathVariable Serializable id) {
//        return wareSkuService.removeById(id);
//    }

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
//    @GetMapping("list")
//    public List<WareSku> list() {
//        return wareSkuService.list();
//    }

    /**
     * 根据商品库存主键获取详细信息。
     *
     * @param id 商品库存主键
     * @return 商品库存详情
     */
    @GetMapping("info/{id}")
    public R getInfo(@PathVariable Serializable id) {
        WareSku byId = wareSkuService.getById(id);
        return R.ok().put("data", byId);
    }

    /**
     * 分页查询商品库存。
     *
     * @param page 分页对象
     * @return 分页对象
     */
    @GetMapping("list")
    public R page(@RequestParam Map<String,Object> pms) {
        Page<WareSku> wareSkuPage = wareSkuService.queryPage(pms);
        return R.ok().put("data", wareSkuPage);
    }
    @PostMapping("/delete")
    public R patchDelete(@RequestBody Long[] ids){
        wareSkuService.patchDelete(ids);
        return R.ok();
    }
}
