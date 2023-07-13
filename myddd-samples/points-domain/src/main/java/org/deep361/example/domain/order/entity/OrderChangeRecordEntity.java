package org.deep361.example.domain.order.entity;

import org.deep361.example.domain.order.valobj.OrderStatus;
import lombok.Data;

import java.util.Date;

@Data
public class OrderChangeRecordEntity {

    private String id;

    /**
     * 订单id
     */
    private String orderId;

    /**
     * 订单最终状态,ORDERED:已下单,PAID:已支付,FINISHED:已完成
     */
    private OrderStatus status;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 版本号
     */
    private Long version;
}
