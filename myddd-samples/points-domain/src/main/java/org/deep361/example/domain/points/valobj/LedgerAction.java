package org.deep361.example.domain.points.valobj;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum LedgerAction {

    /**
     * 账户动作
     */
    INCOME("入账"),
    OUTCOME("出账"),

    ;

    private String desc;
}
