package cn.rlfit.gulimall.product.mapper;

import cn.rlfit.gulimall.product.domain.PmsCommentReplay;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 18777
* @description 针对表【pms_comment_replay(商品评价回复关系)】的数据库操作Mapper
* @createDate 2024-03-12 14:00:00
* @Entity cn.rlfit.gulimall.product.domain.PmsCommentReplay
*/
@Mapper
public interface PmsCommentReplayMapper {

    int deleteByPrimaryKey(Long id);

    int insert(PmsCommentReplay record);

    int insertSelective(PmsCommentReplay record);

    PmsCommentReplay selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PmsCommentReplay record);

    int updateByPrimaryKey(PmsCommentReplay record);

}
