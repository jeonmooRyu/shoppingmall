package com.example.coupang.interfaces.product;

import com.example.coupang.domain.enums.ProductType;
import com.example.coupang.domain.enums.ServiceType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

public class ProductDto {

    @Getter
    @Setter
    @ToString
    public static class ProductRegistRequest {
        private String productName;
        private ProductType productType;
        private ServiceType serviceType;
        private BigDecimal price;
        private String seller;
        private String image;
    }


}
