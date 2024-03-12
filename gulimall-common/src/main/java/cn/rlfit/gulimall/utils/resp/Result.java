package cn.rlfit.gulimall.utils.resp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 12/03/2024 2:37 PM
 */
@Data
public class Result<T> implements Serializable {
    private T data;
    private String message;
    private String code;

    public Result() {
    }

    public static <T> String build(ReturnCodeEnum returnCodeEnum, T body) {
        Result<T> result = new Result<>();
        if (!Objects.isNull(body)) result.data = body;
        result.code = returnCodeEnum.getCode();
        result.message = returnCodeEnum.getMessage();
        ObjectMapper objectMapper = new ObjectMapper();
        String ok = "";
        try {
            ok = objectMapper.writeValueAsString(result);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return ok;
    }

    // 成功
    public static <T> String ok(String code, T data) {
        ReturnCodeEnum codeResult = ReturnCodeEnum.getCodeResult(code);
        return build(codeResult, data);
    }

    // 失败
    public static <T> String fail(String code, T data) {
        return build(ReturnCodeEnum.getCodeResult(code), data);
    }
}

