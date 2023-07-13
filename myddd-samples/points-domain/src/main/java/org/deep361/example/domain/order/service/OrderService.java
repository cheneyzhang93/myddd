package org.deep361.example.domain.order.service;

import org.deep361.example.domain.order.repository.IOrderRepository;
import org.deep361.example.domain.order.entity.OrderEntity;
import org.deep361.example.domain.order.entity.OrderItemEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

@Service
public class OrderService {

    @Autowired(required = false)
    IOrderRepository iOrderRepository;

    public OrderEntity getById(String id) {
        OrderEntity order = iOrderRepository.getById(id);
        order.setItems(getItems(id));
        return order;
    }

    /**
     * 创建订单
     */
    @Transactional(rollbackFor = Exception.class)
    public OrderEntity create(String userId, List<OrderItemEntity> items) {
        OrderEntity order = new OrderEntity();
        order.init(userId, items);
        persistent(order);
        return order;
    }

    @Transactional(rollbackFor = Exception.class)
    public void pay(String orderId, BigDecimal payAmount) {
        OrderEntity order = getById(orderId);
        order.pay(payAmount);
        persistent(order);
    }

    /**
     * 退款中
     */
    @Transactional(rollbackFor = Exception.class)
    public void returning(String orderId) {
        OrderEntity order = getById(orderId);
        order.returning();
        persistent(order);
    }

    /**
     * 完成
     */
    @Transactional(rollbackFor = Exception.class)
    public void finish(String orderId) {
        OrderEntity order = getById(orderId);
        order.submit();
        persistent(order);
    }

    /**
     * 关闭
     */
    @Transactional(rollbackFor = Exception.class)
    public void close(String orderId) {
        OrderEntity order = getById(orderId);
        order.close();
        persistent(order);
    }

    private void persistent(OrderEntity order) {
        // save
    }

    public List<OrderItemEntity> getItems(String orderId) {
        return Collections.emptyList();
    }
}
