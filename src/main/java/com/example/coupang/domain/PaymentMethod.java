package com.example.coupang.domain;

import com.example.coupang.domain.baseTime.BaseTime;
import com.example.coupang.domain.enums.Bank;
import com.example.coupang.domain.enums.CardCompany;
import com.example.coupang.domain.enums.PaymentType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Getter
public class PaymentMethod extends BaseTime {

    @Id private Long id;
    @Setter private PaymentType paymentType;
    @Setter private Bank bank;
    @Setter private CardCompany cardCompany;
    @Setter private String cardNumber;
    @Setter private String account;

    @ManyToOne
    @JoinColumn(name = "users.id")
    private Users user;

}
