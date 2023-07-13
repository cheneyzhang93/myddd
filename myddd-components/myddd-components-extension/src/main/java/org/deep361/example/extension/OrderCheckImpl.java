package org.deep361.example.extension;

public class OrderCheckImpl implements IOrderCheck {

    public OrderCheckImpl() {
        put(this);
    }

    @Override
    public boolean check(String sourceId) {
        // feignClient
        return false;
    }

    @Override
    public int order() {
        return 0;
    }
}
