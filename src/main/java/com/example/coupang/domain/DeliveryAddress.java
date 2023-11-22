package com.example.coupang.domain;

import com.example.coupang.domain.baseTime.BaseTime;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
public class DeliveryAddress extends BaseTime {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
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
