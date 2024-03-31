package cn.rlfit.gulimall.product.feign;


import cn.rlfit.gulimall.to.SkuReduction;
import cn.rlfit.gulimall.to.SpuBoundsTo;
import cn.rlfit.gulimall.utils.resp.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 31/03/2024 1:41 PM
 */
@FeignClient("gulimall-coupon")
public interface CouponFeignService {

    /**
     * 调用的基本流程
     * 将传递过来的数据转换成json对象，需要写上注解
     * 找到服务，发送请求
     * 将json放到请求体位置，发送请求
     * 对方服务收到请求，实际上收到的是json数据
     * 将json转换为接收的类型，只要上一步的json中存在字段和这个实体类对应就可以转
     * @param spuBoundsTo 传入的json
     */
    @PostMapping("/coupon/spubounds/save")
    R saveSpuBounds(@RequestBody SpuBoundsTo spuBoundsTo);

    @PostMapping("/coupon/skufullreduction/saveInfo")
    R saveSkuReduction(@RequestBody SkuReduction skuReduction);
}
