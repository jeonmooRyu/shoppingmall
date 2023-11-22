package com.example.coupang.domain;

import com.example.coupang.domain.baseTime.BaseTime;
import com.example.coupang.domain.enums.Role;
import com.example.coupang.domain.enums.UserType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Users extends BaseTime {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Setter private String uid;
    @Setter private String name;
    @Setter private String phoneNumber;
    @Setter private UserType userType;
    @Setter private Role role;
    @Setter private Integer point;

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

}
