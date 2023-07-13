package org.deep361.example.domain.goods.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class GoodsEntity {
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 单价
     */
    private BigDecimal goodsPrice;


}
