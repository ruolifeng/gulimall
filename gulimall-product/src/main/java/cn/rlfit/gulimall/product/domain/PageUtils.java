package cn.rlfit.gulimall.product.domain;

import lombok.Data;

import java.util.List;

/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 19/03/2024 11:23 AM
 */
@Data
public class PageUtils<T> {
    private List<T> data;
    private Integer totalCount;
    private Integer pageSize;
    private Integer totalPage;
    private Integer currentPage;
}
