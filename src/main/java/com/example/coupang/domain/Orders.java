package com.example.coupang.domain;

import com.example.coupang.domain.baseTime.BaseTime;
import com.example.coupang.domain.enums.OrderStatus;
import com.example.coupang.domain.enums.PaymentType;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Orders extends BaseTime {
    @Id private Long id;
    @Setter private String uid; // 구매자 uid
    @Setter private String orderNumber;
    @Setter private String receiverName;
    @Setter private String receiverTel;
    @Setter private String receiverEmail;
    @Setter private String receiverAddr;
    @Setter private String receiverAddrDetail;
    @Setter private String deliveryMsg;
    @Setter private BigDecimal totalPrice;
    @Setter private BigDecimal deliveryFee;
    @Setter private BigDecimal promotionDiscount;
    @Setter private PaymentType paymentType;
    @Setter private OrderStatus orderStatus;

}
