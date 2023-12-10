package com.example.coupang.domain.payment;

import com.example.coupang.domain.baseEntity.BaseEntity;
import com.example.coupang.domain.enums.PaymentType;
import com.example.coupang.domain.orders.Orders;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@Getter
@ToString
public class Payment extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Setter private BigDecimal payAmount;
    @Setter private String payCompanyCode;  // 결제사에서 발급한 결제코드
    @Setter private PaymentType paymentType;

    @OneToOne
    @JoinColumn(name = "orders.id")
    @Setter
    private Orders orders;

    @Builder
    public Payment(BigDecimal payAmount, String payCompanyCode, PaymentType paymentType) {
        this.payAmount = payAmount;
        this.payCompanyCode = payCompanyCode;
        this.paymentType = paymentType;
    }
}
