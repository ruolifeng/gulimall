package cn.rlfit.gulimallware.service.impl;

import cn.rlfit.gulimallware.entity.Purchase;
import cn.rlfit.gulimallware.mapper.PurchaseMapper;
import cn.rlfit.gulimallware.service.PurchaseService;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 采购信息 服务层实现。
 *
 * @author ruolifeng
 * @since 2024-04-01 12:37:31
 */
@Service
public class PurchaseServiceImpl extends ServiceImpl<PurchaseMapper, Purchase> implements PurchaseService {
}
