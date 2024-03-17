package cn.rlfit.gulimall.utils.exception;

/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 17/03/2024 6:13 PM
 */
public enum ExceptionCode {
    UNKNOW_EXCEPTION(10000,"系统未知异常"),
    VALID_EXCEPTION(10001, "参数校验失败");

    private int code;
    private String message;

    ExceptionCode(int code,String message){
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
