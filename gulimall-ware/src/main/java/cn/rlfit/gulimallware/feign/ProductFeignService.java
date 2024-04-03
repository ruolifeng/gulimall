package cn.rlfit.gulimallware.feign;

import cn.rlfit.gulimall.utils.resp.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 03/04/2024 2:48 PM
 */
@FeignClient("gulimall-product")
public interface ProductFeignService {
    @GetMapping("/product/skuinfo/info/{skuId}")
    public R info(@PathVariable Long skuId);
}
