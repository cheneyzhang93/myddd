package org.deep361.example.domain.order.valobj;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PayStatus {

    /**
     * 支付状态
     */
    UN_PAY("待支付"),
    PAID("已支付");

    private String desc;

    private String getDesc() {
        return this.desc;
    }

}
