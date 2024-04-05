package cn.rlfit.gulimallware.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import cn.rlfit.gulimallware.entity.WareSku;
import cn.rlfit.gulimallware.mapper.WareSkuMapper;
import cn.rlfit.gulimallware.service.WareSkuService;
import org.springframework.stereotype.Service;

/**
 * 商品库存 服务层实现。
 *
 * @author ruolifeng
 * @since 2024-04-04 18:02:29
 */
@Service
public class WareSkuServiceImpl extends ServiceImpl<WareSkuMapper, WareSku> implements WareSkuService {

}
