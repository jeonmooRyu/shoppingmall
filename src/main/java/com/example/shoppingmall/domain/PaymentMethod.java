package com.example.shoppingmall.domain;

import com.example.shoppingmall.domain.baseEntity.BaseEntity;
import com.example.shoppingmall.domain.enums.Bank;
import com.example.shoppingmall.domain.enums.CardCompany;
import com.example.shoppingmall.domain.enums.PaymentType;
import com.example.shoppingmall.domain.users.Users;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
public class PaymentMethod extends BaseEntity {

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
