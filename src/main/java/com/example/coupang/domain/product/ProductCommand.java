package com.example.coupang.domain.product;

import com.example.coupang.domain.enums.ProductType;
import com.example.coupang.domain.enums.ServiceType;
import lombok.*;

import java.math.BigDecimal;

public class ProductCommand {

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ProductRegist {
        private String productName;
        private ProductType productType;
        private ServiceType serviceType;
        private BigDecimal price;
        private String detailImage;
        private String thumbnail;

        public Product toEntity() {
            return Product.builder()
                    .productName(productName)
                    .productType(productType)
                    .serviceType(serviceType)
                    .price(price)
                    .detailImage(detailImage)
                    .thumbnail(thumbnail)
                    .build();
        }
    }
}
