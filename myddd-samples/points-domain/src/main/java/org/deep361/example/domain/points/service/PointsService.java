package org.deep361.example.domain.points.service;

import org.deep361.example.domain.points.repository.IPointsLedgerDetailRepository;
import org.deep361.example.domain.points.repository.IPointsLedgerRepository;
import org.deep361.example.domain.points.entity.PointsLedgerDetailEntity;
import org.deep361.example.domain.points.entity.PointsLedgerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PointsService {

    @Autowired(required = false)
    IPointsLedgerRepository iPointsLedgerRepository;

    @Autowired(required = false)
    IPointsLedgerDetailRepository iPointsLedgerDetailRepository;

    public PointsLedgerEntity get(String userId) {
        return iPointsLedgerRepository.getByUserId(userId);
    }

    public String income(String userId, BigDecimal amount) {
        PointsLedgerDetailEntity ledgerDetail = new PointsLedgerDetailEntity();
        ledgerDetail.income(userId, amount);
        iPointsLedgerDetailRepository.save(ledgerDetail);
        return ledgerDetail.getId();
    }

    public String outcome(String userId, String orderId, BigDecimal amount) {
        PointsLedgerDetailEntity ledgerDetail = new PointsLedgerDetailEntity();
        ledgerDetail.outcome(userId, orderId, amount);
        iPointsLedgerDetailRepository.save(ledgerDetail);
        return ledgerDetail.getId();
    }

}
