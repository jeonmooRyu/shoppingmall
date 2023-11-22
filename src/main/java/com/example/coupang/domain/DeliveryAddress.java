package com.example.coupang.domain;

import com.example.coupang.domain.baseTime.BaseTime;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Getter
public class DeliveryAddress extends BaseTime {

    @Id private Long id;
    @Setter private String uid;
    @Setter private Boolean isDefault;
    @Setter private Boolean isRocketWow;
    @Setter private Boolean isRocketFresh;
    @Setter private String addressName;
    @Setter private String address;
    @Setter private String addressDetail;
    @Setter private String receiverTel;
    @Setter private String dayTimeDeliverMsg;
    @Setter private String nightTimeDeliverMsg;

    @ManyToOne
    @JoinColumn(name = "users.id")
    private Users user;
}
