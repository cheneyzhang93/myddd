package org.deep361.example.extension;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OrderCheckProcess {

    /**
     * 处理检查
     *
     * @param sourceId
     * @return
     */
    public static boolean check(String sourceId) {
        List<IOrderCheck> sorted = Optional.of(IOrderCheck.CHECKS).orElse(Collections.emptyList()).stream().sorted(Comparator.comparingInt(IOrderCheck::order)).collect(Collectors.toList());
        for (IOrderCheck iOrderCheck : sorted) {
            if (!iOrderCheck.check(sourceId)) {
                return false;
            }
        }
        return true;
    }

}
