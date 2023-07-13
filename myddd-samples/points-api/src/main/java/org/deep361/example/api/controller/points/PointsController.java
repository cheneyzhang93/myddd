package org.deep361.example.api.controller.points;

import org.deep361.example.api.data.converter.PointsApiConverter;
import org.deep361.example.application.points.PointsAppService;
import org.deep361.example.contract.points.IPointsController;
import org.deep361.example.contract.points.data.vo.points.PointsLedgerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PointsController implements IPointsController {

    @Autowired
    PointsAppService pointsAppService;

    @Autowired
    PointsApiConverter pointsApiConverter;

    @Override
    public PointsLedgerVo ledger(String userId) {
        return pointsApiConverter.toPointsLedgerVo(pointsAppService.ledger(userId));
    }

}
