package org.deep361.example.domain.order.entity;

import org.deep361.example.domain.order.valobj.Amount;
import lombok.Data;

@Data
public class OrderGoodsSnapshotEntity {

    /**
     * id
     */
    private String id;

    /**
     * 主订单Id
     */
    private String orderId;

    /**
     * 主订单Id
     */
    private String orderItemId;

    /**
     * 商品id
     */
    private String originalId;

    /**
     * 商品code
     */
    private String goodsCode;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 商品类别code
     */
    private String categoryCode;

    /**
     * 商品类别名称
     */
    private String categoryName;

    /**
     * 商品单价
     */
    private Amount goodsPrice;

    /**
     * 商品简介
     */
    private String goodsDesc;

    /**
     * 商品图片
     */
    private String goodsPic;

    /**
     * 商品简图
     */
    private String shortPic;

    /**
     * 版本号
     */
    private Long version;
}
