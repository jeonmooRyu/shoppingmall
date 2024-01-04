package com.example.shoppingmall.domain.cart;

import com.example.shoppingmall.domain.baseEntity.BaseEntity;
import com.example.shoppingmall.domain.enums.Option;
import com.example.shoppingmall.domain.product.Product;
import com.example.shoppingmall.domain.users.Users;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Cart extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Setter
    private String uid;
    @Setter
    @Enumerated(value = EnumType.STRING)
    private Option option;
    @Setter
    private Integer quantity;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product.id")
    @Setter
    private Product product;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "users.id")
    private Users user;

    @Builder
    public Cart(String uid, Option option, Integer quantity) {
        this.uid = uid;
        this.option = option;
        this.quantity = quantity;
    }
}
