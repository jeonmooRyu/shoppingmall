package com.example.coupang.domain;

import com.example.coupang.domain.baseTime.BaseTime;
import com.example.coupang.domain.enums.CardCompany;
import com.example.coupang.domain.product.Product;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
public class Promotion extends BaseTime {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Setter private String promotionCode;
    @Setter private CardCompany cardCompany;
    @Setter private BigDecimal discountRate;
    @Setter private LocalDateTime promotionStartDateTime;
    @Setter private LocalDateTime promotionEndDateTime;

    @ManyToOne
    @JoinColumn(name = "product.id")
    private Product product;
}
