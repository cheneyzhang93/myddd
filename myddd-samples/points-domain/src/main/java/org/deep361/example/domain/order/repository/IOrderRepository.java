package org.deep361.example.domain.order.repository;

import org.deep361.example.domain.order.entity.OrderEntity;

public interface IOrderRepository {

    /**
     * 详情
     *
     * @param id
     * @return
     */
    OrderEntity getById(String id);

}
