package cn.rlfit.gulimallmember.domain;

import lombok.Data;

/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 29/03/2024 1:55 PM
 */
/**
 * 会员收藏的专题活动
 */
@Data
public class UmsMemberCollectSubject {
    /**
    * id
    */
    private Long id;

    /**
    * subject_id
    */
    private Long subjectId;

    /**
    * subject_name
    */
    private String subjectName;

    /**
    * subject_img
    */
    private String subjectImg;

    /**
    * 活动url
    */
    private String subjectUrll;
}