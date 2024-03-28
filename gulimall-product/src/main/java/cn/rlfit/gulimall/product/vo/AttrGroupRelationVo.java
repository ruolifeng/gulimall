package cn.rlfit.gulimall.product.vo;

/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 28/03/2024 1:14 PM
 */
public class AttrGroupRelationVo {
    private Long attrId;
    private Long attrGroupId;

    public Long getAttrId() {
        return attrId;
    }

    public void setAttrId(Long attrId) {
        this.attrId = attrId;
    }

    public Long getAttrGroupId() {
        return attrGroupId;
    }

    public void setAttrGroupId(Long attrGroupId) {
        this.attrGroupId = attrGroupId;
    }

    @Override
    public String toString() {
        return "AttrGroupRelationVo{" +
                "attrId=" + attrId +
                ", attrGroupId=" + attrGroupId +
                '}';
    }
}
