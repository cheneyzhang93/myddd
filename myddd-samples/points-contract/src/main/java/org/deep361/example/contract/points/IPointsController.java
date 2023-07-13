package org.deep361.example.contract.points;

import org.deep361.example.contract.Router;
import org.deep361.example.contract.points.data.vo.points.PointsLedgerVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(url = "${service.domain[econtect-interests].url:http://econtact-interests-svc.stable:8080}", name = "econtectPointsClient")
public interface IPointsController {

    /**
     * 积分账户
     *
     * @return
     */
    @GetMapping(Router.POINTS_LEDGER)
    PointsLedgerVo ledger(@PathVariable(name = "userId") String userId);

}
