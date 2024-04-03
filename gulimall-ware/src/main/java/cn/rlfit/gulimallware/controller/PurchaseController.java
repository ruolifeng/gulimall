package cn.rlfit.gulimallware.controller;

import cn.rlfit.gulimall.utils.resp.R;
import cn.rlfit.gulimallware.entity.Purchase;
import cn.rlfit.gulimallware.service.PurchaseService;
import cn.rlfit.gulimallware.vo.MergeVo;
import cn.rlfit.gulimallware.vo.PurchaseDoneVo;
import com.mybatisflex.core.paginate.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Map;

/**
 * 采购信息 控制层。
 *
 * @author ruolifeng
 * @since 2024-04-01 12:37:31
 */
@RestController
@RequestMapping("ware/purchase")
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
    public R save(@RequestBody Purchase purchase) {
        purchase.setCreateTime(LocalDateTime.now());
        purchase.setUpdateTime(LocalDateTime.now());
        System.out.println(purchase);
        purchaseService.save(purchase);
        return R.ok();
    }
//
//    /**
//     * 根据主键删除采购信息。
//     *
//     * @param id 主键
//     * @return {@code true} 删除成功，{@code false} 删除失败
//     */
//    @DeleteMapping("remove/{id}")
//    public boolean remove(@PathVariable Serializable id) {
//        return purchaseService.removeById(id);
//    }

    /**
     * 根据主键更新采购信息。
     *
     * @param purchase 采购信息
     * @return {@code true} 更新成功，{@code false} 更新失败
     */
    @PostMapping("update")
    public R update(@RequestBody Purchase purchase) {
        purchaseService.updateById(purchase);
        return R.ok();
    }

//    /**
//     * 查询所有采购信息。
//     *
//     * @return 所有数据
//     */
//    @GetMapping("list")
//    public List<Purchase> list() {
//        return purchaseService.list();
//    }

    /**
     * 根据采购信息主键获取详细信息。
     *
     * @param id 采购信息主键
     * @return 采购信息详情
     */
    @GetMapping("info/{id}")
    public R getInfo(@PathVariable Serializable id) {
        Purchase byId = purchaseService.getById(id);
        return R.ok().put("data", byId);
    }

    /**
     * 分页查询采购信息。
     *
     * @param page 分页对象
     * @return 分页对象
     */
    @GetMapping("list")
    public R page(@RequestParam Map<String, Object> pms) {
        Page<Purchase> purchasePage = purchaseService.pageListAll(pms);
        return R.ok().put("data", purchasePage);
    }

    @PostMapping("/delete")
    public R deleteAll(@RequestBody Long[] ids) {
        purchaseService.deleteAll(ids);
        return R.ok();
    }

    @GetMapping("/unreceive/list")
    public R unreceiveList(@RequestParam Map<String, Object> pms) {
        Page<Purchase> purchasePage = purchaseService.unreceiveList(pms);
        return R.ok().put("data", purchasePage);
    }

    @PostMapping("/merge")
    public R merge(@RequestBody MergeVo mergeVo){
        purchaseService.merge(mergeVo);
        return R.ok();
    }

    /**
     * 领取采购单（一些细节的地方暂时不考虑）
     * @param ids 领取的采购单id
     * @return 领取状态
     */
    @PostMapping("/receive")
    public R receive(@RequestBody Long[] ids){
        purchaseService.recevied(ids);
        return R.ok();
    }

    @PostMapping("/done")
    public R finish(@RequestBody PurchaseDoneVo purchaseDoneVo){
        purchaseService.done(purchaseDoneVo);
        return R.ok();
    }
}
