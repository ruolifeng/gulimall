package cn.rlfit.gulimall.product.exception;

import cn.rlfit.gulimall.utils.exception.ExceptionCode;
import cn.rlfit.gulimall.utils.resp.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 集中处理异常
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 17/03/2024 4:57 PM
 */
@Slf4j
@RestController
@ControllerAdvice(basePackages = "cn/rlfit/gulimall/product/controller")
public class GulimallExceptionControllerAdvice {
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public R handleValidException(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        Map<String, String> map = new HashMap<>();
        List<FieldError> errors = bindingResult.getFieldErrors();
        errors.forEach(x->{
            map.put(x.getField(), x.getDefaultMessage());
        });
        return R.error(ExceptionCode.VALID_EXCEPTION.getCode(),ExceptionCode.VALID_EXCEPTION.getMessage()).put("data", map);
    }

    @ExceptionHandler(value = Throwable.class)
    public R handleException(Exception e){
        return R.error(ExceptionCode.UNKNOW_EXCEPTION.getCode(),ExceptionCode.UNKNOW_EXCEPTION.getMessage());
    }
}
