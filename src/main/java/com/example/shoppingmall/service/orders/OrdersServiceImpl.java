package com.example.shoppingmall.service.orders;

import com.example.shoppingmall.domain.orders.Orders;
import com.example.shoppingmall.repository.OrdersRepository;
import com.example.shoppingmall.repository.support.OrdersRepositorySupport;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrdersServiceImpl implements OrdersService{

    private final OrdersRepository ordersRepository;
    private final OrdersRepositorySupport ordersRepositorySupport;

    @Transactional
    public Orders registOrder(Orders orders) {
        return ordersRepository.save(orders);
    }

    @Override
    public List<Orders> getOrders(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        return ordersRepositorySupport.findOrders(startDateTime, endDateTime);
    }

    @Transactional
    public Orders getOrder(String orderToken) {
        return ordersRepository.findOrdersByOrderToken(orderToken);
    }

    @Transactional
    public Orders checkout(Orders orders, String receiverName, String receiverTel, String receiverAddr, String receiverAddrDetail, String deliveryMsg) {
        return orders.checkout(receiverName, receiverTel, receiverAddr, receiverAddrDetail, deliveryMsg);
    }

}
