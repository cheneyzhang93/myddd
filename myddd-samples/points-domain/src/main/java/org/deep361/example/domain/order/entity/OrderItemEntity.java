package org.deep361.example.domain.order.entity;

import lombok.Data;

@Data
public class OrderItemEntity {

    /**
     * 订单item id
     */
    private String id;

    /**
     * 主订单id
     */
    private String orderId;

    /**
     * 购买商品的快照
     */
    private OrderGoodsSnapshotEntity goodsSnapshot;

    /**
     * 购买商品数量
     */
    private Long quantity;

    /**
     * 备注
     */
    private String remark;

    /**
     * 版本号
     */
    private Long version;

    public OrderItemEntity() {
    }


    public OrderItemEntity(OrderGoodsSnapshotEntity goodsSnapshot, Long quantity) {
        this.goodsSnapshot = goodsSnapshot;
        this.quantity = quantity;
    }

    public OrderItemEntity(OrderGoodsSnapshotEntity goodsSnapshot, Long quantity, String remark) {
        this.goodsSnapshot = goodsSnapshot;
        this.quantity = quantity;
        this.remark = remark;
    }

}
