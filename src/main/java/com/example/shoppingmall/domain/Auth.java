package com.example.shoppingmall.domain;

import com.example.shoppingmall.domain.baseEntity.BaseEntity;
import com.example.shoppingmall.domain.users.Users;
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
