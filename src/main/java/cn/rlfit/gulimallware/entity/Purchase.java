package cn.rlfit.gulimallware.entity;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serial;

/**
 * 采购信息 实体类。
 *
 * @author ruolifeng
 * @since 2024-04-04 18:02:29
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(value = "wms_purchase")
public class Purchase implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 采购单id
     */
    @Id(keyType = KeyType.Auto)
    private Long id;

    /**
     * 采购人id
     */
    private Long assigneeId;

    /**
     * 采购人名
     */
    private String assigneeName;

    /**
     * 联系方式
     */
    private String phone;

    /**
     * 优先级
     */
    private Integer priority;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 仓库id
     */
    private Long wareId;

    /**
     * 总金额
     */
    private BigDecimal amount;

    /**
     * 创建日期
     */
    private LocalDateTime createTime;

    /**
     * 更新日期
     */
    private LocalDateTime updateTime;

}
