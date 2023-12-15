package com.example.coupang.service.orders;

import com.example.coupang.domain.orders.Orders;

public interface OrdersService {

    Orders registOrder(Orders order);

    Orders getOrder(String orderToken);

    Orders checkout(Orders orders, String receiverName, String receiverTel, String receiverAddr, String receiverAddrDetail, String deliveryMsg);



}
