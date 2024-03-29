package cn.rlfit.gulimallmember.service;

import java.util.List;
import cn.rlfit.gulimallmember.domain.UmsMemberReceiveAddress;
    /**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 29/03/2024 1:56 PM
 */
public interface UmsMemberReceiveAddressService{

    int deleteByPrimaryKey(Long id);

    int insert(UmsMemberReceiveAddress record);

    int insertSelective(UmsMemberReceiveAddress record);

    UmsMemberReceiveAddress selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UmsMemberReceiveAddress record);

    int updateByPrimaryKey(UmsMemberReceiveAddress record);

    int batchInsert(List<UmsMemberReceiveAddress> list);

}
