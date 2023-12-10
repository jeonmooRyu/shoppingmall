package com.example.coupang.domain.product;

import com.example.coupang.common.TokenGenerator;
import com.example.coupang.domain.Promotion;
import com.example.coupang.domain.Review;
import com.example.coupang.domain.baseEntity.BaseEntity;
import com.example.coupang.domain.enums.ProductType;
import com.example.coupang.domain.enums.ServiceType;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class Product extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Setter private String productCode;
    @Setter private String productName;
    @Setter private ProductType productType;
    @Setter private ServiceType serviceType;
    @Setter private BigDecimal price;
    @Setter private Boolean isDelete;
//    @Setter private String seller;
    @Setter private String image;

//    @OneToOne(mappedBy = "product")
//    @JoinColumn
//    private OrdersDetail ordersDetail;

    @OneToMany(mappedBy = "product")
    private List<Review> review;

    @OneToMany(mappedBy = "product")
    private List<Promotion> promotions;

    @Builder
    public Product(String productName, ProductType productType, ServiceType serviceType, BigDecimal price, String seller, String image) {
        this.productCode = TokenGenerator.generateProductCode();
        this.productName = productName;
        this.productType = productType;
        this.serviceType = serviceType;
        this.price = price;
        this.isDelete = false;
//        this.seller = seller;
        this.image = image;
    }
}
