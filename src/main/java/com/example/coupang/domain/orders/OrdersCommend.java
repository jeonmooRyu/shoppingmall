package com.example.coupang.domain.orders;

import com.example.coupang.domain.enums.PaymentType;
import com.example.coupang.domain.payment.Payment;
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
//        private String orderNumber;
        private String receiverName;
        private String receiverTel;
//        private String receiverEmail;
        private String receiverAddr;
        private String receiverAddrDetail;
        private String deliveryMsg;
        private BigDecimal totalPrice;
        private BigDecimal price;
        private BigDecimal deliveryFee;
        private BigDecimal promotionDiscount;
        private PaymentType paymentType;
        private List<OrdersDetail> ordersDetails;

        public Orders toEntity() {
            var orders = Orders.builder()
                    .uid(uid)
                    .receiverName(receiverName)
                    .receiverTel(receiverTel)
//                    .receiverEmail(receiverEmail)
                    .receiverAddr(receiverAddr)
                    .receiverAddrDetail(receiverAddrDetail)
                    .deliveryMsg(deliveryMsg)
                    .totalPrice(totalPrice)
                    .promotionDiscount(promotionDiscount)
                    .paymentType(paymentType)
//                    .ordersDetails(ordersDetails.stream().map(OrdersDetail::toEntity).toList())
                    .build();

            // details 생성 및 연관관계설정
            var details = ordersDetails.stream()
                    .map(OrdersDetail::toEntity)
                    .toList();
            orders.setOrdersDetails(details);

            // payment 생성 및 연관관계설정
            var payment = Payment.builder()
                    .payAmount(orders.getTotalPrice())
                    .paymentType(orders.getPaymentType())
                    .build();
            orders.setPayment(payment);

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
            private BigDecimal originPrice;   // 원래 가격
            private BigDecimal discount;   // 할인액
            private BigDecimal finalPrice;   // 최종 금액 ( 원래가격 - 할인액 )
            private Integer quantity;

            public com.example.coupang.domain.orders.OrdersDetail toEntity() {
                return com.example.coupang.domain.orders.OrdersDetail.builder()
                        .productCode(productCode)
                        .productName(productName)
                        .originPrice(originPrice)
                        .discount(discount)
                        .finalPrice(finalPrice)
                        .quantity(quantity)
                        .build();
            }
        }
    }

}
