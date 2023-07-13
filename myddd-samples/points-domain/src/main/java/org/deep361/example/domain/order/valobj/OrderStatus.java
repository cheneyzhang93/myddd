package org.deep361.example.domain.order.valobj;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderStatus {

    /**
     * 正向订单
     */
    UN_PAY("待支付"),
    UN_DELIVERY("待发货"),
    FINISHED("已完成"),
    RETURNING("退款中"),
    CLOSE("已关闭"),

    ;


    private String desc;

}
