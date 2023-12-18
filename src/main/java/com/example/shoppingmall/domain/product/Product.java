package com.example.shoppingmall.domain.product;

import com.example.shoppingmall.common.TokenGenerator;
import com.example.shoppingmall.domain.Promotion;
import com.example.shoppingmall.domain.Review;
import com.example.shoppingmall.domain.baseEntity.BaseEntity;
import com.example.shoppingmall.domain.enums.ProductType;
import com.example.shoppingmall.domain.enums.ServiceType;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
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
    @Setter @Size(max = 1000)
    private String detailImage;
    @Setter private String thumbnail;
    @Setter private String option;

//    @OneToOne(mappedBy = "product")
//    @JoinColumn
//    private OrdersDetail ordersDetail;

    @OneToMany(mappedBy = "product")
    private List<Review> review;

    @OneToMany(mappedBy = "product")
    private List<Promotion> promotions;

    @Builder
    public Product(String productName, ProductType productType, ServiceType serviceType, BigDecimal price, String seller, String detailImage, String thumbnail, String option) {
        this.productCode = TokenGenerator.generateProductCode();
        this.productName = productName;
        this.productType = productType;
        this.serviceType = serviceType;
        this.price = price;
        this.isDelete = false;
//        this.seller = seller;
        this.detailImage = detailImage;
        this.thumbnail = thumbnail;
        this.option = option;
    }
}
