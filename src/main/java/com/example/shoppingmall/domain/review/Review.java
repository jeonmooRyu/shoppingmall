package com.example.shoppingmall.domain.review;

import com.example.shoppingmall.domain.baseEntity.BaseEntity;
import com.example.shoppingmall.domain.product.Product;
import com.example.shoppingmall.domain.users.Users;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class Review extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Setter private String uid;
//    @Setter private String productCode;
    @Setter private String content;
//    @Setter private String summary;
    @Setter private Integer score;

    @Setter
    @OneToOne
    @JoinColumn(name = "users.id")
    private Users users;

    @Setter
    @ManyToOne
    @JoinColumn(name = "product.id")
    private Product product;

    @Builder
    public Review(String content, Integer score) {
        this.content = content;
        this.score = score;
    }

//    public void setUsers(Users users) {
//        this.users = users;
//    }
}
