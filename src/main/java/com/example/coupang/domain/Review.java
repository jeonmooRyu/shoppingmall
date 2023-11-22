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
public class Review extends BaseTime {

    @Id private Long id;
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
