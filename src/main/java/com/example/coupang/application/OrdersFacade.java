package com.example.coupang.application;

import com.example.coupang.domain.orders.Orders;
import com.example.coupang.domain.orders.OrdersCommend;
import com.example.coupang.repository.OrdersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrdersFacade {

    private final OrdersRepository ordersRepository;

    public Orders registOrder(OrdersCommend.RegistOrders commend) {
        var orders = commend.toEntity();
        return ordersRepository.save(orders);
    }
}
