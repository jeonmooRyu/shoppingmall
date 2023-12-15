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
public class Cart extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Setter private String uid;
    @Setter private String productCode;
    @Setter private Integer quantity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "users.id")
    private Users user;
}
