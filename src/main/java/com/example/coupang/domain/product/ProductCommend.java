package com.example.coupang.domain.product;

import com.example.coupang.domain.enums.ProductType;
import com.example.coupang.domain.enums.ServiceType;
import lombok.*;

import java.math.BigDecimal;

public class ProductCommend {

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ProductRegist {
        private String productCode;
        private String productName;
        private ProductType productType;
        private ServiceType serviceType;
        private BigDecimal price;
        private String seller;
        private String image;

        public Product toEntity() {
            return Product.builder()
                    .productCode(productCode)
                    .productName(productName)
                    .productType(productType)
                    .serviceType(serviceType)
                    .price(price)
                    .seller(seller)
                    .image(image)
                    .build();
        }
    }
}
