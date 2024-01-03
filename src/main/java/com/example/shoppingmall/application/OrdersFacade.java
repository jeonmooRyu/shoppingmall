package com.example.shoppingmall.application;

import com.example.shoppingmall.domain.orders.Orders;
import com.example.shoppingmall.domain.orders.OrdersCommand;
import com.example.shoppingmall.interfaces.orders.OrdersDto;
import com.example.shoppingmall.interfaces.payment.PaymentDto;
import com.example.shoppingmall.service.orders.OrdersService;
import com.example.shoppingmall.service.payment.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrdersFacade {

    private final OrdersService ordersService;
    private final PaymentService paymentService;

    @Transactional
    public Orders registOrder(OrdersCommand.RegistOrders command) {
        var orders = command.toEntity();
        return ordersService.registOrder(orders);
    }

    @Transactional
    public List<Orders> getOrders(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        return ordersService.getOrders(startDateTime, endDateTime);
    }

    @Transactional
    public Orders getOrder(String orderToken) {
        return ordersService.getOrders(orderToken);
    }

    @Transactional
    public Orders checkoutOrder(OrdersDto.CheckoutOrderDto checkoutOrderDto, PaymentDto.PaymentRequest paymentRequest) {
        // 결제 진행
        var orders = ordersService.getOrders(checkoutOrderDto.getOrderToken());
        paymentService.payOrders(orders, paymentRequest);

        // order checkout process
        var receiverName = checkoutOrderDto.getReceiverName();
        var receiverTel = checkoutOrderDto.getReceiverTel();
        var receiverAddr = checkoutOrderDto.getReceiverAddr();
        var receiverAddrDetail = checkoutOrderDto.getReceiverAddrDetail();
        var deliveryMsg = checkoutOrderDto.getDeliveryMsg();
        return ordersService.checkout(orders, receiverName, receiverTel, receiverAddr, receiverAddrDetail, deliveryMsg);
    }



}
