package com.example.shoppingmall.interfaces.cart;

import com.example.shoppingmall.domain.enums.Option;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

public class CartDto {

    @Getter
    @Setter
    @ToString
    public static class CartResponse {
        private Long cartId;
        private String thumbnail;
        private String productName;
        private Option option;
        private Integer quantity;
        private String price;
        private String productCode;
    }


    @Getter
    @Setter
    @ToString
    public static class AddCartRequest {
        private List<CartDetail> cartDetails;

        @Getter
        @Setter
        @ToString
        public static class CartDetail {
            private Option option;
            private Integer quantity;
            private String productCode;
        }
    }

    @Getter
    @Setter
    @ToString
    public static class CartResultResponse {
        private Boolean isSuccess;
    }

    @Getter
    @Setter
    @ToString
    public static class DeleteCartRequest {
        private List<Long> cartIds;
    }



}
