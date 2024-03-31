package cn.rlfit.gulimall.product.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * spu信息介绍
 * @TableName pms_spu_info_desc
 */
@Data
public class PmsSpuInfoDesc implements Serializable {
    /**
     * 商品id
     */
    private Long spuId;

    /**
     * 商品介绍
     */
    private String decript;

    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        PmsSpuInfoDesc other = (PmsSpuInfoDesc) that;
        return (this.getSpuId() == null ? other.getSpuId() == null : this.getSpuId().equals(other.getSpuId()))
            && (this.getDecript() == null ? other.getDecript() == null : this.getDecript().equals(other.getDecript()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSpuId() == null) ? 0 : getSpuId().hashCode());
        result = prime * result + ((getDecript() == null) ? 0 : getDecript().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", spuId=").append(spuId);
        sb.append(", decript=").append(decript);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}