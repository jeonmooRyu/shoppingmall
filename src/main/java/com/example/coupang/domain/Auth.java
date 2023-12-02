package com.example.coupang.domain;

import com.example.coupang.domain.baseEntity.BaseEntity;
import com.example.coupang.domain.users.Users;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
public class Auth extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "users.id")
    private Users user;
}
