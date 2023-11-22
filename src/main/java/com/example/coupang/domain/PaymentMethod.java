package com.example.coupang.domain;

import com.example.coupang.domain.baseTime.BaseTime;
import com.example.coupang.domain.enums.Bank;
import com.example.coupang.domain.enums.CardCompany;
import com.example.coupang.domain.enums.PaymentType;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
public class PaymentMethod extends BaseTime {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Setter private PaymentType paymentType;
    @Setter private Bank bank;
    @Setter private CardCompany cardCompany;
    @Setter private String cardNumber;
    @Setter private String account;

    @ManyToOne
    @JoinColumn(name = "users.id")
    private Users user;

}
