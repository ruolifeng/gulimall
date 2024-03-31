package cn.rlfit.gulimallcoupon.service.impl;

import cn.rlfit.gulimall.to.MemberPrice;
import cn.rlfit.gulimall.to.SkuReduction;
import cn.rlfit.gulimallcoupon.domain.SmsMemberPrice;
import cn.rlfit.gulimallcoupon.domain.SmsSkuFullReduction;
import cn.rlfit.gulimallcoupon.domain.SmsSkuLadder;
import cn.rlfit.gulimallcoupon.mapper.SmsMemberPriceMapper;
import cn.rlfit.gulimallcoupon.mapper.SmsSkuFullReductionMapper;
import cn.rlfit.gulimallcoupon.mapper.SmsSkuLadderMapper;
import cn.rlfit.gulimallcoupon.service.SmsSkuFullReductionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 31/03/2024 1:16 PM
 */
@Service
public class SmsSkuFullReductionServiceImpl implements SmsSkuFullReductionService{

    @Autowired
    private SmsSkuFullReductionMapper smsSkuFullReductionMapper;
    @Autowired
    SmsSkuLadderMapper smsSkuLadderMapper;
    @Autowired
    SmsMemberPriceMapper smsMemberPriceMapper;
    @Override
    public int deleteByPrimaryKey(Long id) {
        return smsSkuFullReductionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SmsSkuFullReduction record) {
        return smsSkuFullReductionMapper.insert(record);
    }

    @Override
    public int insertSelective(SmsSkuFullReduction record) {
        return smsSkuFullReductionMapper.insertSelective(record);
    }

    @Override
    public SmsSkuFullReduction selectByPrimaryKey(Long id) {
        return smsSkuFullReductionMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SmsSkuFullReduction record) {
        return smsSkuFullReductionMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SmsSkuFullReduction record) {
        return smsSkuFullReductionMapper.updateByPrimaryKey(record);
    }

    @Override
    public int batchInsert(List<SmsSkuFullReduction> list) {
        return smsSkuFullReductionMapper.batchInsert(list);
    }

    @Override
    public void saveSkuReduciton(SkuReduction skuReduction) {
        // 保存满减打折和会员价
        SmsSkuLadder smsSkuLadder = new SmsSkuLadder();
        smsSkuLadder.setSkuId(skuReduction.getSkuId());
        smsSkuLadder.setFullCount(skuReduction.getFullCount());
        smsSkuLadder.setDiscount(skuReduction.getDiscount());
        smsSkuLadder.setAddOther(skuReduction.getCountStatus() == 1);
//        smsSkuLadder.setPrice();
        smsSkuLadderMapper.insertSelective(smsSkuLadder);
        // 保存满减信息
        SmsSkuFullReduction smsSkuFullReduction = new SmsSkuFullReduction();
        BeanUtils.copyProperties(skuReduction, smsSkuFullReduction);
        smsSkuFullReductionMapper.insertSelective(smsSkuFullReduction);
        // 会员价格
        List<MemberPrice> memberPrice = skuReduction.getMemberPrice();
        List<SmsMemberPrice> collect = memberPrice.stream().map(price -> {
            SmsMemberPrice smsMemberPrice = new SmsMemberPrice();
            smsMemberPrice.setSkuId(skuReduction.getSkuId());
            smsMemberPrice.setMemberLevelId(price.getId());
            smsMemberPrice.setMemberLevelName(price.getName());
            smsMemberPrice.setMemberPrice(price.getPrice());
            smsMemberPrice.setAddOther(true);
            return smsMemberPrice;
        }).toList();
        for (SmsMemberPrice smsMemberPrice : collect) {
            smsMemberPriceMapper.insertSelective(smsMemberPrice);
        }
    }

}
