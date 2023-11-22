package com.example.coupang.domain;

import com.example.coupang.domain.baseTime.BaseTime;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
public class OrdersDetail extends BaseTime {

    @Id private Long id;
    @Setter private String orderNumber;
    @Setter private String productCode;
    @Setter private BigDecimal unitPrice;   // 개당 가격
    @Setter private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "orders.id")
    private Orders order;

    @OneToOne
    @JoinColumn(name = "product.id")
    private Product product;


}
