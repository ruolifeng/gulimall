package cn.rlfit.gulimallware.controller;

import cn.rlfit.gulimall.utils.resp.R;
import cn.rlfit.gulimallware.entity.PurchaseDetail;
import cn.rlfit.gulimallware.service.PurchaseDetailService;
import com.mybatisflex.core.paginate.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.Map;

/**
 *  控制层。
 *
 * @author ruolifeng
 * @since 2024-04-01 12:37:31
 */
@RestController
@RequestMapping("ware/purchasedetail")
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
    public R save(@RequestBody PurchaseDetail purchaseDetail) {
        purchaseDetailService.save(purchaseDetail);
        return R.ok();
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
//
//    /**
//     * 查询所有。
//     *
//     * @return 所有数据
//     */
//    @GetMapping("list")
//    public List<PurchaseDetail> list() {
//        return purchaseDetailService.list();
//    }

    /**
     * 根据主键获取详细信息。
     *
     * @param id 主键
     * @return 详情
     */
    @GetMapping("info/{id}")
    public R getInfo(@PathVariable Serializable id) {
        PurchaseDetail byId = purchaseDetailService.getById(id);
        return R.ok().put("data", byId);

    }

    /**
     * 分页查询。
     *
     * @param page 分页对象
     * @return 分页对象
     */
    @GetMapping("list")
    public R page(@RequestParam Map<String, Object> pms) {
        Page<PurchaseDetail> purchasePage = purchaseDetailService.pageListAll(pms);
        return R.ok().put("data", purchasePage);
    }

    @PostMapping("/delete")
    public R deleteAll(@RequestBody Long[] ids) {
        purchaseDetailService.deleteAll(ids);
        return R.ok();
    }
}
