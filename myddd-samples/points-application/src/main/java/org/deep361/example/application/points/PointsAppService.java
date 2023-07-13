package org.deep361.example.application.points;

import org.deep361.example.application.points.converter.PointsAppConverter;
import org.deep361.example.application.points.dto.PointsLedgerDTO;
import org.deep361.example.domain.goods.entity.GoodsEntity;
import org.deep361.example.domain.order.entity.OrderEntity;
import org.deep361.example.domain.order.entity.OrderGoodsSnapshotEntity;
import org.deep361.example.domain.order.entity.OrderItemEntity;
import org.deep361.example.domain.order.service.OrderService;
import org.deep361.example.domain.points.service.PointsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.UUID;

@Service
public class PointsAppService {

    @Autowired(required = false)
    PointsService pointsService;

    @Autowired(required = false)
    PointsAppConverter pointsAppConverter;

    @Autowired(required = false)
    OrderService orderService;

    public PointsLedgerDTO ledger(String userId) {
        return pointsAppConverter.toPointsLedgerDto(pointsService.get(userId));
    }

    @Transactional(rollbackFor = Exception.class)
    public void buy(GoodsEntity goods, String userId) {
        // 生成商品快照
        OrderGoodsSnapshotEntity goodsSnapshot = pointsAppConverter.toOrderGoodsSnapshotEntity(goods);
        goodsSnapshot.setId(UUID.randomUUID().toString());
        // 生成订单条目
        OrderItemEntity orderItem = new OrderItemEntity(goodsSnapshot, BigDecimal.ONE.longValue());
        // 生成订单
        OrderEntity order = orderService.create(userId, Collections.singletonList(orderItem));
        // 记录出账
        pointsService.outcome(userId, order.getId(), goods.getGoodsPrice());
        // 支付
        orderService.pay(order.getId(), goods.getGoodsPrice());
    }

}
