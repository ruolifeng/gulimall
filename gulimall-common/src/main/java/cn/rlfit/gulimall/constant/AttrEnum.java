package cn.rlfit.gulimall.constant;

/**
 * 经常使用的常量字段
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 28/03/2024 12:25 PM
 */
public enum AttrEnum {
    ATTR_TYPE_BASE(1, "基本属性"), ATTR_TYPE_SALE(0, "销售属性");

    private Integer code;
    private String msg;

    AttrEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
