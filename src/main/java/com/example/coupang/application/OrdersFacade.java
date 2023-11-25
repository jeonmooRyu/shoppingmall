package com.example.coupang.application;

import com.example.coupang.domain.orders.Orders;
import com.example.coupang.domain.orders.OrdersCommend;
import com.example.coupang.repository.OrdersRepository;
import com.example.coupang.service.users.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrdersFacade {

    private final OrdersRepository ordersRepository;
    private final ProductService productService;

    public Orders registOrder(OrdersCommend.RegistOrders commend) {
        commend.getOrdersDetails().forEach(detail -> {
            var product = productService.getProductByProductCode(detail.getProductCode());
            detail.setProductName(product.getProductName());
        });

        var orders = commend.toEntity();
        return ordersRepository.save(orders);
    }
}
