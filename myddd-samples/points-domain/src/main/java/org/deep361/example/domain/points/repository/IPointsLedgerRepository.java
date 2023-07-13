package org.deep361.example.domain.points.repository;

import org.deep361.example.domain.points.entity.PointsLedgerEntity;

public interface IPointsLedgerRepository {

    /**
     * 根据用户获取账户信息
     *
     * @param userId
     * @return
     */
    PointsLedgerEntity getByUserId(String userId);

}
