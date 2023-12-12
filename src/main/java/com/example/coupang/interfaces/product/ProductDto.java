package com.example.coupang.interfaces.product;

import com.example.coupang.domain.enums.ProductType;
import com.example.coupang.domain.enums.ServiceType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;

public class ProductDto {

    @Getter
    @Setter
    @ToString
    public static class ProductRegistRequest {
        private String productName;
        private ProductType productType;
        private ServiceType serviceType;
        private BigDecimal price;
        private String detailImage;
        private String thumbnail;
    }

    @Getter
    @Setter
    @ToString
    public static class ProductResponses {

        private List<ProductDetail> productDetails;

        @Getter
        @Setter
        @ToString
        public static class ProductDetail {
            private String productCode;
            private String productName;
            private String detailImage;
            private BigDecimal price;   // 원래 가격
        }

    }

    @Getter
    @Setter
    @ToString
    public static class ProductResponse {
        private String productCode;
        private String productName;
        private String detailImage;
        private BigDecimal price;   // 원래 가격
    }

}
