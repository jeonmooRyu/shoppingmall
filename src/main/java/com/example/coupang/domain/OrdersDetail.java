package com.example.coupang.domain;

import com.example.coupang.domain.baseTime.BaseTime;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class OrdersDetail extends BaseTime {

    @Id private Long id;
    @Setter private String orderNumber;
    @Setter private String productCode;
    @Setter private BigDecimal unitPrice;   // 개당 가격
    @Setter private Integer quantity;


}
