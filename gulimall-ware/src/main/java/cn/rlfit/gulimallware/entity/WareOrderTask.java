package cn.rlfit.gulimallware.entity;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serial;

/**
 * 库存工作单 实体类。
 *
 * @author ruolifeng
 * @since 2024-04-01 12:37:31
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(value = "wms_ware_order_task")
public class WareOrderTask implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @Id(keyType = KeyType.Auto)
    private Long id;

    /**
     * order_id
     */
    private Long orderId;

    /**
     * order_sn
     */
    private String orderSn;

    /**
     * 收货人
     */
    private String consignee;

    /**
     * 收货人电话
     */
    private String consigneeTel;

    /**
     * 配送地址
     */
    private String deliveryAddress;

    /**
     * 订单备注
     */
    private String orderComment;

    /**
     * 付款方式【 1:在线付款 2:货到付款】
     */
    private Boolean paymentWay;

    /**
     * 任务状态
     */
    private Integer taskStatus;

    /**
     * 订单描述
     */
    private String orderBody;

    /**
     * 物流单号
     */
    private String trackingNo;

    /**
     * create_time
     */
    private LocalDateTime createTime;

    /**
     * 仓库id
     */
    private Long wareId;

    /**
     * 工作单备注
     */
    private String taskComment;

}
