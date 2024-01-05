package com.example.shoppingmall.interfaces.orders;

import com.example.shoppingmall.domain.enums.CardCompany;
import com.example.shoppingmall.domain.enums.Option;
import com.example.shoppingmall.domain.enums.OrderStatus;
import com.example.shoppingmall.domain.enums.PaymentType;
import com.example.shoppingmall.domain.users.Users;
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
        private Integer totalQuantity;
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
        }
    }

    @Getter
    @Setter
    @ToString
    public static class RegistOrderResponse {
        //        private String uid;
        private String orderToken;
    }

    // checkout 화면으로 넘기는 클래스
    @Getter
    @Setter
    @ToString
    public static class CheckoutViewResponse {
        private Long id;
        private String uid; // 구매자 uid
        private String orderToken;
        private Boolean isPay;
        private String receiverName;
        private String receiverTel;
        private String receiverEmail;
        private String receiverAddr;
        private String receiverAddrDetail;
        private String deliveryMsg;
        private BigDecimal totalPrice;      // 상품가격 + 배송비
        private Integer totalQuantity;
        private BigDecimal deliveryFee;
        private BigDecimal promotionDiscount;
        private PaymentType paymentType;
        private OrderStatus orderStatus;
        private Users user;
        private List<OrdersDetail> ordersDetails;

        @Getter
        @Setter
        @ToString
        public static class OrdersDetail {
            private Long id;
            private String productCode;
            private String productName;
            private BigDecimal originPrice;   // 원래 가격
            private BigDecimal discount;   // 할인액
            private BigDecimal finalPrice;   // 최종 금액 ( 원래가격 - 할인액 )
            private Option option;
            private Integer quantity;
        }
    }


    @Getter
    @Setter
    @ToString
    public static class CheckoutOrderRequest {
        private String orderToken;
        private BigDecimal totalPrice;
        private BigDecimal deliveryFee;
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
        private BigDecimal totalPrice;
        private BigDecimal deliveryFee;
        private String receiverName;
        private String receiverTel;
        private String receiverAddr;
        private String receiverAddrDetail;
        private String deliveryMsg;
    }

    @Getter
    @Setter
    @ToString
    public static class OrdersHistoryResponse {
        private String thumbnail;
        private String orderToken;
        private Integer totalPrice;
        private String totalQuantity;
        private LocalDateTime createdAt;
        private List<OrdersDetail> ordersDetails;

        @Getter
        @Setter
        @ToString
        public static class OrdersDetail {
            private String productName;
            private String productCode;
            private Integer originPrice;
            private String quantity;
            private Option option;
        }

    }

}
