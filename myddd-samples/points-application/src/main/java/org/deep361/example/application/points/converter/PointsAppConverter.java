package org.deep361.example.application.points.converter;

import org.deep361.example.application.points.dto.PointsLedgerDTO;
import org.deep361.example.domain.order.valobj.Amount;
import org.deep361.example.domain.goods.entity.GoodsEntity;
import org.deep361.example.domain.order.entity.OrderGoodsSnapshotEntity;
import org.deep361.example.domain.points.entity.PointsLedgerEntity;
import org.springframework.stereotype.Component;

@Component
public class PointsAppConverter {

    public PointsLedgerDTO toPointsLedgerDto(PointsLedgerEntity entity) {
        PointsLedgerDTO dto = new PointsLedgerDTO();
        dto.setBalance(entity.getBalance().getAmount());
        dto.setTotalIncome(entity.getTotalIncome().getAmount());
        dto.setTotalOutcome(entity.getTotalOutcome().getAmount());
        return dto;
    }

    public OrderGoodsSnapshotEntity toOrderGoodsSnapshotEntity(GoodsEntity entity) {
        OrderGoodsSnapshotEntity orderGoodsSnapshotEntity = new OrderGoodsSnapshotEntity();
        orderGoodsSnapshotEntity.setGoodsPrice(Amount.builder().amount(entity.getGoodsPrice()).build());
        return orderGoodsSnapshotEntity;
    }

}
