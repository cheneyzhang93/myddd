package org.deep361.example.application.points.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PointsLedgerDTO {
    /**
     * 余额
     */
    private BigDecimal balance;
    /**
     * 总收入
     */
    private BigDecimal totalIncome;

    /**
     * 总支出
     */
    private BigDecimal totalOutcome;

    public PointsLedgerDTO() {
        this.balance = BigDecimal.ZERO;
        this.totalIncome = BigDecimal.ZERO;
        this.totalOutcome = BigDecimal.ZERO;
    }
}
