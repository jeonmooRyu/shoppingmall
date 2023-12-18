package com.example.shoppingmall.domain.orders;

import com.example.shoppingmall.domain.baseEntity.BaseEntity;
import com.example.shoppingmall.domain.enums.Option;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class OrdersDetail extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
//    @Setter private String orderNumber;
    @Setter private String productCode;
    @Setter private String productName;
    @Setter private BigDecimal originPrice;   // 원래 가격
    @Setter private BigDecimal discount;   // 할인액
    @Setter private BigDecimal finalPrice;   // 최종 금액 ( 원래가격 - 할인액 )
    @Setter private Option option;
    @Setter private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "orders.id")
    private Orders orders;

//    @OneToOne
//    @JoinColumn(name = "product.id")
//    private Product product;

    @Builder
    public OrdersDetail(String productCode, String productName, BigDecimal originPrice, BigDecimal discount, BigDecimal finalPrice, Option option, Integer quantity, Orders orders) {
        this.productCode = productCode;
        this.productName = productName;
        this.originPrice = originPrice;
        this.discount = discount;
        this.finalPrice = finalPrice;
        this.option = option;
        this.quantity = quantity;
        this.orders = orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }
}
