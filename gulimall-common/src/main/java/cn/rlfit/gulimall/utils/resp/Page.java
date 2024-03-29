package cn.rlfit.gulimall.utils.resp;

import lombok.Data;

/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 29/03/2024 2:28 PM
 */
@Data
public class Page<T> {
    private T data;
    private Integer totalCount;
    private Integer currentPage;
    private Integer TotalPage;
}
