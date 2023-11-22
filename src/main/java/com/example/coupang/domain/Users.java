package com.example.coupang.domain;

import com.example.coupang.domain.baseTime.BaseTime;
import com.example.coupang.domain.enums.Role;
import com.example.coupang.domain.enums.UserType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@ToString
public class Users extends BaseTime {

    @Id private Long id;
    @Setter private String uid;
    @Setter private String name;
    @Setter private String phoneNumber;
    @Setter private UserType userType;
    @Setter private Role role;
    @Setter private Integer point;

    @OneToMany(mappedBy = "user")
    private List<Orders> orders;

    @OneToMany(mappedBy = "user")
    private List<Cart> carts;

    @OneToMany(mappedBy = "user")
    private List<DeliveryAddress> deliveryAddresses;

    @OneToMany(mappedBy = "user")
    private List<PaymentMethod> paymentMethods;

    @OneToMany(mappedBy = "user")
    private List<Auth> auths;

}
