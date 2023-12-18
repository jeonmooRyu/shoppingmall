package com.example.shoppingmall.domain.product;

import com.example.shoppingmall.domain.enums.ProductType;
import com.example.shoppingmall.domain.enums.ServiceType;
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
        private String option;
        private ProductType productType;
        private ServiceType serviceType;
        private BigDecimal price;
        private String detailImage;
        private String thumbnail;

        public Product toEntity() {
            return Product.builder()
                    .productName(productName)
                    .option(option)
                    .productType(productType)
                    .serviceType(serviceType)
                    .price(price)
                    .detailImage(detailImage)
                    .thumbnail(thumbnail)
                    .build();
        }
    }
}
