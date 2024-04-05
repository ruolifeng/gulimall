package cn.rlfit.gulimallware.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import cn.rlfit.gulimallware.entity.WareInfo;
import cn.rlfit.gulimallware.mapper.WareInfoMapper;
import cn.rlfit.gulimallware.service.WareInfoService;
import org.springframework.stereotype.Service;

/**
 * 仓库信息 服务层实现。
 *
 * @author ruolifeng
 * @since 2024-04-04 18:02:29
 */
@Service
public class WareInfoServiceImpl extends ServiceImpl<WareInfoMapper, WareInfo> implements WareInfoService {

}
