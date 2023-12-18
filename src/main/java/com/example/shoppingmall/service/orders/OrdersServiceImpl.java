package com.example.shoppingmall.service.orders;

import com.example.shoppingmall.domain.orders.Orders;
import com.example.shoppingmall.repository.OrdersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrdersServiceImpl implements OrdersService{

    private final OrdersRepository ordersRepository;

    @Transactional
    public Orders registOrder(Orders orders) {
        return ordersRepository.save(orders);
    }

    @Transactional
    public Orders getOrder(String orderToken) {
        return ordersRepository.findOrderByOrderToken(orderToken);
    }

    @Transactional
    public Orders checkout(Orders orders, String receiverName, String receiverTel, String receiverAddr, String receiverAddrDetail, String deliveryMsg) {
        return orders.checkout(receiverName, receiverTel, receiverAddr, receiverAddrDetail, deliveryMsg);
    }

}
