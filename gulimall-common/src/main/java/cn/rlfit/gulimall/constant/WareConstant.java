package cn.rlfit.gulimall.constant;

/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 03/04/2024 11:38 AM
 */
public enum WareConstant {
    CREATED(0,"新建"),ASSIGNED(1,"已分配"),RECEIVE(2,"已领取"),FINISH(3,"已完成"),HASERROR(4,"有异常");
    private int code;
    private String msg;
    WareConstant(int code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
