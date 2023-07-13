package org.deep361.example.domain.points.entity;

import org.deep361.example.domain.points.valobj.Amount;
import lombok.Data;

@Data
public class PointsLedgerEntity {

    /**
     * 所属人
     */
    private String userId;

    /**
     * 余额
     */
    private Amount balance;

    /**
     * 总收入
     */
    private Amount totalIncome;

    /**
     * 总支出
     */
    private Amount totalOutcome;

}
