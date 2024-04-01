package cn.rlfit.gulimallware.controller;

import cn.rlfit.gulimall.utils.resp.R;
import cn.rlfit.gulimallware.entity.WareInfo;
import cn.rlfit.gulimallware.service.WareInfoService;
import com.mybatisflex.core.paginate.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.Map;

/**
 * 仓库信息 控制层。
 *
 * @author ruolifeng
 * @since 2024-04-01 12:37:31
 */
@RestController
@RequestMapping("/ware/wareinfo")
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
    public R save(@RequestBody WareInfo wareInfo) {
        wareInfoService.save(wareInfo);
        return R.ok();
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

//    /**
//     * 查询所有仓库信息。
//     *
//     * @return 所有数据
//     */
//    @GetMapping("list")
//    public List<WareInfo> list() {
//        return wareInfoService.list();
//    }

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
    @GetMapping("list")
    public R page(@RequestParam Map<String, Object> params) {
        Page<WareInfo> page =  wareInfoService.GetFoPage(params);
        return R.ok().put("data", page);
    }

}
