package org.deep361.example.domain.order.entity;

import lombok.Data;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.deep361.example.domain.order.valobj.*;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Data
public class OrderEntity {

    /**
     * 主键
     */
    private String id;

    /**
     * 订单状态
     */
    private OrderStatus status;

    /**
     * 购买人id
     */
    private String userId;

    /**
     * 支付时间
     */
    private Date payTime;

    /**
     * 订单总金额
     */
    private Amount totalAmount;

    /**
     * 实际支付金额
     */
    private Amount actualAmount;

    /**
     * 订单条目
     */
    private List<OrderItemEntity> items;

    /**
     * 初始化订单
     *
     * @param userId
     */
    public void init(String userId, List<OrderItemEntity> orderItems) {
        // 初始化主订单
        this.id = UUID.randomUUID().toString();
        this.userId = userId;
        this.actualAmount = Amount.builder().amount(BigDecimal.ZERO).build();
        this.totalAmount = Amount.builder().amount(BigDecimal.ZERO).build();
        this.status = OrderStatus.UN_PAY;
        // 需要初始化订单条目
        this.items = Optional.of(orderItems).orElse(Collections.emptyList()).stream().peek(item -> {
            item.setId(UUID.randomUUID().toString());
            item.setOrderId(this.id);
            item.getGoodsSnapshot().setOrderId(this.id);
            item.getGoodsSnapshot().setOrderItemId(item.getId());
            // 计算订单item
            BigDecimal amount = BigDecimal.valueOf(item.getQuantity()).multiply(item.getGoodsSnapshot().getGoodsPrice().getAmount());
            // 累加主订单价格
            this.actualAmount = Amount.builder().amount(this.actualAmount.getAmount().add(amount)).build();
            this.totalAmount = Amount.builder().amount(this.totalAmount.getAmount().add(amount)).build();
        }).collect(Collectors.toList());
    }

    public void pay(BigDecimal payAmount) {
        this.payTime = new Date();
        this.actualAmount = Amount.builder().amount(payAmount).build();
        this.status = OrderStatus.UN_DELIVERY;
    }

    /**
     * 支付完提交订单完成
     */
    public void submit() {
        this.status = OrderStatus.FINISHED;
    }

    /**
     * 发起退款正向订单更改退款中
     */
    public void returning() {
        this.status = OrderStatus.RETURNING;
    }

    /**
     * 退款成功正向订单更改为关闭
     */
    public void close() {
        this.status = OrderStatus.CLOSE;
    }

}
