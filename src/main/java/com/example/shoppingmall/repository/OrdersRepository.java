package com.example.shoppingmall.repository;

import com.example.shoppingmall.domain.orders.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {

    Orders findOrderByOrderToken(String orderToken);

}
