package com.example.coupang.domain.orders;

import com.example.coupang.domain.enums.PaymentType;
import com.example.coupang.interfaces.orders.OrdersDto;
import lombok.*;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrdersCommend {

    @NoArgsConstructor
    @AllArgsConstructor
    @Setter
    @Getter
    @Builder
    @ToString
    public static class RegistOrders {
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

        public Orders toEntity() {
            var orders = Orders.builder()
                    .uid(uid)
                    .receiverName(receiverName)
                    .receiverTel(receiverTel)
                    .receiverEmail(receiverEmail)
                    .receiverAddr(receiverAddr)
                    .receiverAddrDetail(receiverAddrDetail)
                    .deliveryMsg(deliveryMsg)
                    .totalPrice(totalPrice)
                    .promotionDiscount(promotionDiscount)
                    .paymentType(paymentType)
//                    .ordersDetails(ordersDetails.stream().map(OrdersDetail::toEntity).toList())
                    .build();

            var details = ordersDetails.stream()
                    .map(OrdersDetail::toEntity)
                    .toList();

            orders.setOrdersDetails(details);
            return orders;
        }

        @NoArgsConstructor
        @AllArgsConstructor
        @Setter
        @Getter
        @Builder
        @ToString
        public static class OrdersDetail {
            private String productCode;
            private String productName;
            private BigDecimal unitPrice;   // 개당 가격
            private Integer quantity;

            public com.example.coupang.domain.orders.OrdersDetail toEntity() {
                return com.example.coupang.domain.orders.OrdersDetail.builder()
                        .productCode(productCode)
                        .productName(productName)
                        .unitPrice(unitPrice)
                        .quantity(quantity)
                        .build();
            }
        }
    }

}
