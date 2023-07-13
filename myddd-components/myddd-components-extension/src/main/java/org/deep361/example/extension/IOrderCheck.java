package org.deep361.example.extension;

import java.util.*;

/**
 * 订单检查
 */
public interface IOrderCheck {

    List<IOrderCheck> CHECKS = new ArrayList<>();

    /**
     * 检查
     *
     * @param sourceId 业务id
     * @return
     */
    boolean check(String sourceId);

    /**
     * 顺序
     *
     * @return
     */
    int order();

    default void put(IOrderCheck check) {
        this.CHECKS.add(check);
    }

}
