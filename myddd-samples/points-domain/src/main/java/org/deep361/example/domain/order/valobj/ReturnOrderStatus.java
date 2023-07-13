package org.deep361.example.domain.order.valobj;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ReturnOrderStatus {

    /**
     * 逆向订单
     */
    UN_RETURN("待退款"),
    FINISHED("已完成"),
    CLOSE("已关闭"),

    ;


    private String desc;

    private String getDesc() {
        return this.desc;
    }

}
