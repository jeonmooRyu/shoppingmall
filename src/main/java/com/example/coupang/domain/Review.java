package com.example.coupang.domain;

import com.example.coupang.domain.baseTime.BaseTime;
import com.example.coupang.domain.product.Product;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
public class Review extends BaseTime {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Setter private String uid;
    @Setter private String productCode;
    @Setter private String createBy;
    @Setter private String contents;
    @Setter private String summary;
    @Setter private String score;

    @ManyToOne
    @JoinColumn(name = "product.id")
    private Product product;
}
