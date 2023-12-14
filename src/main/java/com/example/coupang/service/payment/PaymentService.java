package com.example.coupang.service.payment;

import com.example.coupang.domain.orders.Orders;
import com.example.coupang.domain.payment.Payment;
import com.example.coupang.interfaces.payment.PaymentDto;

public interface PaymentService {

    void payOrders(Orders orders, PaymentDto.PaymentRequest request);

    Payment save(Payment payment);

}
