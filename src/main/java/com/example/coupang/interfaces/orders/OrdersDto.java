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
    public static class RegistOrderRequest {
        private String uid;
        private String orderNumber;
        private String receiverName;
        private String receiverTel;
        private String receiverEmail;
        private String receiverAddr;
        private String receiverAddrDetail;
        private String deliveryMsg;
        private BigDecimal totalPrice;
        private BigDecimal deliveryFee;
        private BigDecimal promotionDiscount;
        private PaymentType paymentType;
        private List<OrdersDetail> ordersDetails;

        @Setter
        @Getter
        @ToString
        public static class OrdersDetail {
            private String productCode;
            private BigDecimal unitPrice;   // 개당 가격
            private Integer quantity;
        }

    }
}
