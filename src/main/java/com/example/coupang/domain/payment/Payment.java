package com.example.coupang.domain.payment;

import com.example.coupang.domain.baseEntity.BaseEntity;
import com.example.coupang.domain.enums.CardCompany;
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
    @Setter @Enumerated(value = EnumType.STRING)
    private PaymentType paymentType;
    @Setter private CardCompany cardCompany;
    @Setter private String cardNo;
    @Setter private String cardExpYear;
    @Setter private String cardExpMon;
    @Setter private String cardCvv;
    @Setter private String cardPw;

    @OneToOne
    @JoinColumn(name = "orders.id")
    private Orders orders;

    @Builder
    public Payment(BigDecimal payAmount, String payCompanyCode, PaymentType paymentType, CardCompany cardCompany, String cardNo, String cardExpYear, String cardExpMon, String cardCvv, String cardPw, Orders orders) {
        this.payAmount = payAmount;
        this.payCompanyCode = payCompanyCode;
        this.paymentType = paymentType;
        this.cardCompany = cardCompany;
        this.cardNo = cardNo;
        this.cardExpYear = cardExpYear;
        this.cardExpMon = cardExpMon;
        this.cardCvv = cardCvv;
        this.cardPw = cardPw;
        this.orders = orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
        orders.setPayment(this);
    }
}
