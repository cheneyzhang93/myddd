package org.deep361.example.domain.order.valobj;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class Amount {

    /**
     * 金额
     */
    private BigDecimal amount;

}
