package org.deep361.example.domain.points.repository;

import org.deep361.example.domain.points.entity.PointsLedgerDetailEntity;

public interface IPointsLedgerDetailRepository {

    /**
     * 保存
     *
     * @param ledgerDetail
     */
    void save(PointsLedgerDetailEntity ledgerDetail);

}
