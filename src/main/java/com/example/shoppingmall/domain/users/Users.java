package com.example.shoppingmall.domain.users;

import com.example.shoppingmall.common.TokenGenerator;
import com.example.shoppingmall.domain.cart.Cart;
import com.example.shoppingmall.domain.baseEntity.BaseEntity;
import com.example.shoppingmall.domain.enums.Authority;
import com.example.shoppingmall.domain.enums.SignUpType;
import com.example.shoppingmall.domain.enums.UserType;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Users extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Setter
    private String email;   // 유저 계정
    @Setter
    private String password;   // 유저 계정
    @Setter
    private String uid;
    @Setter
    private String name;
    @Setter
    private String phoneNumber;
    @Setter
    @Enumerated(value = EnumType.STRING)
    private UserType userType;
    @Setter
    @Enumerated(value = EnumType.STRING)
    private Authority authority;
    @Setter
    private Integer point;
    @Setter
    @Enumerated(value = EnumType.STRING)
    private SignUpType signUpType;

    //    @OneToMany(mappedBy = "user")
//    private List<Orders> orders;
//
    @OneToMany(mappedBy = "user")
    private List<Cart> carts = new ArrayList<>();
//
//    @OneToMany(mappedBy = "user")
//    private List<DeliveryAddress> deliveryAddresses;
//
//    @OneToMany(mappedBy = "user")
//    private List<PaymentMethod> paymentMethods;
//
//    @OneToMany(mappedBy = "user")
//    private List<Auth> auths;

    @Builder
    private Users(String email, String name, String phoneNumber, String password, String uid, SignUpType signUpType) {
        this.email = email;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.password = signUpType == SignUpType.COMMON ? password : null;
        this.userType = UserType.MEMBER_COMMON;
        this.uid = uid == null ? TokenGenerator.generateUid() : uid;
        this.point = 0;
        this.authority = Authority.ROLE_COMMON;
        this.signUpType = signUpType;
    }

}
