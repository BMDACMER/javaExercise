package com.gh.dataobject;

import com.gh.enums.OrderStatusEnum;
import com.gh.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@DynamicUpdate
public class OrderMaster {

    // 订单Id
    @Id
    private String orderId;

    // 买家名字
    private String buyerName;

    /** 买家手机号. */
    private String buyerPhone;

    // 买家地址
    private String buyerAddress;

    // 买家微信
    private String buyerOpenid;

    // 订单金额
    private BigDecimal orderAmount;

    // 订单状态，默认为新下单
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    // 支付状态，默认为0 未支付
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    // 创建时间
    private Date createTime;

    // 更新时间
    private Date updateTime;

}
