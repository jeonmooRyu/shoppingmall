package com.example.shoppingmall.service.orders;

import com.example.shoppingmall.domain.enums.PaymentType;
import com.example.shoppingmall.domain.orders.Orders;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface OrdersService {

    Orders registOrder(Orders order);

    List<Orders> getOrders(LocalDateTime startDateTime, LocalDateTime endDateTime);

    Orders getOrders(String orderToken);

    Orders checkout(Orders orders, PaymentType paymentType, BigDecimal totalPrice, BigDecimal deliveryFee, String receiverName, String receiverTel, String receiverAddr, String receiverAddrDetail, String deliveryMsg);



}
