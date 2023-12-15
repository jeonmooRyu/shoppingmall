package com.example.shoppingmall.service.payment;

import com.example.shoppingmall.domain.orders.Orders;
import com.example.shoppingmall.domain.payment.Payment;
import com.example.shoppingmall.interfaces.payment.PaymentDto;

public interface PaymentService {

    void payOrders(Orders orders, PaymentDto.PaymentRequest request);

    Payment save(Payment payment);

}
