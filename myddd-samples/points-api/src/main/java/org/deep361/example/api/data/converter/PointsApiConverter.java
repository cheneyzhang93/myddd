package org.deep361.example.api.data.converter;

import org.deep361.example.application.points.dto.PointsLedgerDTO;
import org.deep361.example.contract.points.data.vo.points.PointsLedgerVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class PointsApiConverter {

    public PointsLedgerVo toPointsLedgerVo(PointsLedgerDTO dto) {
        PointsLedgerVo vo = new PointsLedgerVo();
        BeanUtils.copyProperties(dto, vo);
        vo.setBalance(dto.getBalance().stripTrailingZeros());
        return vo;
    }

}
