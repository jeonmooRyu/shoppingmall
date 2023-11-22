package com.example.coupang.domain;

import com.example.coupang.domain.baseTime.BaseTime;
import com.example.coupang.domain.enums.ProductType;
import com.example.coupang.domain.enums.ServiceType;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
public class Product extends BaseTime {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Setter private String productCode;
    @Setter private ProductType productType;
    @Setter private ServiceType serviceType;
    @Setter private BigDecimal price;
    @Setter private Boolean isDelete;
    @Setter private String seller;

    @OneToOne(mappedBy = "product")
    @JoinColumn
    private OrdersDetail ordersDetail;

    @OneToMany(mappedBy = "product")
    private List<Review> review;

    @OneToMany(mappedBy = "product")
    private List<Promotion> promotions;


}
