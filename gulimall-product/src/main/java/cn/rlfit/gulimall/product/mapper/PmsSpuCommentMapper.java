package cn.rlfit.gulimall.product.mapper;

import cn.rlfit.gulimall.product.domain.PmsSpuComment;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 18777
* @description 针对表【pms_spu_comment(商品评价)】的数据库操作Mapper
* @createDate 2024-03-12 14:00:15
* @Entity cn.rlfit.gulimall.product.domain.PmsSpuComment
*/
@Mapper
public interface PmsSpuCommentMapper {

    int deleteByPrimaryKey(Long id);

    int insert(PmsSpuComment record);

    int insertSelective(PmsSpuComment record);

    PmsSpuComment selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PmsSpuComment record);

    int updateByPrimaryKey(PmsSpuComment record);

}
