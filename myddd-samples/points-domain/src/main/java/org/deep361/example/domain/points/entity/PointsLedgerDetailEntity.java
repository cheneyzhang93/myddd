package org.deep361.example.domain.points.entity;

import org.deep361.example.domain.points.valobj.Amount;
import org.deep361.example.domain.points.valobj.LedgerAction;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class PointsLedgerDetailEntity {

    private String id;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 金额
     */
    private Amount amount;

    /**
     * 动作
     */
    private LedgerAction action;

    /**
     * 订单id
     */
    private String orderId;

    /**
     * 入账
     */
    public void income(String userId, BigDecimal amount) {
        this.id = UUID.randomUUID().toString();
        this.action = LedgerAction.INCOME;
        this.userId = userId;
        this.amount = Amount.builder().amount(amount).build();
    }

    /**
     * 出账
     */
    public void outcome(String userId, String orderId, BigDecimal amount) {
        this.id = UUID.randomUUID().toString();
        this.action = LedgerAction.OUTCOME;
        this.userId = userId;
        this.orderId = orderId;
        this.amount = Amount.builder().amount(amount).build();
    }

}
