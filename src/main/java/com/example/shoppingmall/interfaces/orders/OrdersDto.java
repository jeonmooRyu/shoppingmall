package com.example.shoppingmall.interfaces.orders;

import com.example.shoppingmall.domain.enums.CardCompany;
import com.example.shoppingmall.domain.enums.Option;
import com.example.shoppingmall.domain.enums.PaymentType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class OrdersDto {

    @Getter
    @Setter
    @ToString
    public static class RegistOrderRequest {
        //        private String uid;
        private BigDecimal totalPrice;
        private Integer totalQuantity;
        private BigDecimal deliveryFee;
        private List<OrdersDetail> ordersDetails;

        @Setter
        @Getter
        @ToString
        public static class OrdersDetail {
            private String productCode;
            private String productName;
            private Option option;
            private Integer quantity;
            private BigDecimal originPrice;   // 원래 가격
            private BigDecimal finalPrice;   // 최종 금액 ( 원래가격 - 할인액 )
        }
    }

    @Getter
    @Setter
    @ToString
    public static class RegistOrderResponse {
        //        private String uid;
        private String orderToken;
    }

    @Getter
    @Setter
    @ToString
    public static class CheckoutOrderRequest {
        private String orderToken;
        private String receiverName;
        private String receiverTel;
        private String receiverAddr;
        private String receiverAddrDetail;
        private String deliveryMsg;
        private PaymentType paymentType;
        private CardCompany cardCompany;
        private String cardNo;
        private String cardExpYear;
        private String cardExpMon;
        private String cardCvv;
        private String cardPw;
    }

    @Getter
    @Setter
    @ToString
    public static class CheckoutOrderResponse {
        private String orderToken;
    }

    @Getter
    @Setter
    @ToString
    public static class CheckoutOrderDto {
        private String orderToken;
        private String receiverName;
        private String receiverTel;
        private String receiverAddr;
        private String receiverAddrDetail;
        private String deliveryMsg;
    }

    @Getter
    @Setter
    @ToString
    public static class CheckoutPaymentDto {
        private PaymentType paymentType;
        private CardCompany cardCompany;
        private String cardNo;
        private String cardExpYear;
        private String cardExpMon;
        private String cardCvv;
        private String cardPw;
    }

    @Getter
    @Setter
    @ToString
    public static class OrdersHistoryResponse {
        private String thumbnail;
        private String orderToken;
        private String totalPrice;
        private String totalQuantity;
        private LocalDateTime createdAt;
        private List<OrdersDetail> ordersDetails;

        @Getter
        @Setter
        @ToString
        public static class OrdersDetail {
            private String productName;
            private BigDecimal originPrice;
            private String quantity;
            private Option option;
        }

    }

}
