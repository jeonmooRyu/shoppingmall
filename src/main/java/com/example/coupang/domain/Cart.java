package com.example.coupang.domain;

import com.example.coupang.domain.baseTime.BaseTime;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
public class Cart extends BaseTime {
    @Id private Long id;
    @Setter private String uid;
    @Setter private String productCode;
    @Setter private Integer quantity;
}
