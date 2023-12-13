package com.example.coupang.interfaces.orders;

import com.example.coupang.domain.enums.PaymentType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;

public class OrdersDto {

    @Getter
    @Setter
    @ToString
    public static class OrderSheetProduct {
        private List<ProductDetail> productDetails;

        @Getter
        @Setter
        @ToString
        public static class ProductDetail {
            private String productCode;
            private String productName;
            private Integer quantity;
            private BigDecimal originPrice;   // 원래 가격
            private BigDecimal discount;   // 할인액
            private BigDecimal finalPrice;   // 최종 금액 ( 원래가격 - 할인액 )
        }
    }

//    @Getter
//    @Setter
//    @ToString
//    public static class OrderSheetProduct {
//        private String productCode;
//        private String productName;
//        private Integer quantity;
//        private BigDecimal originPrice;   // 원래 가격
//        private BigDecimal discount;   // 할인액
//        private BigDecimal finalPrice;   // 최종 금액 ( 원래가격 - 할인액 )
//    }



    @Getter
    @Setter
    @ToString
    public static class RegistOrderRequest {
        private String uid;
        private String receiverName;
        private String receiverTel;
        private String receiverAddr;
        private String receiverAddrDetail;
        private String deliveryMsg;
        private BigDecimal totalPrice;
        private BigDecimal price;
        private BigDecimal deliveryFee;
        private BigDecimal promotionDiscount;
        private PaymentType paymentType;
//        private String paymentType;
        private List<OrdersDetail> ordersDetails;

        @Setter
        @Getter
        @ToString
        public static class OrdersDetail {
            private String productCode;
            private String productName;
            private Integer quantity;
            private BigDecimal originPrice;   // 원래 가격
            private BigDecimal discount;   // 할인액
            private BigDecimal finalPrice;   // 최종 금액 ( 원래가격 - 할인액 )
        }

    }
}
