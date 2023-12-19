package com.example.shoppingmall.service.orders;

import com.example.shoppingmall.domain.orders.Orders;

import java.util.List;

public interface OrdersService {

    Orders registOrder(Orders order);

    List<Orders> getOrder();

    Orders getOrder(String orderToken);

    Orders checkout(Orders orders, String receiverName, String receiverTel, String receiverAddr, String receiverAddrDetail, String deliveryMsg);



}
