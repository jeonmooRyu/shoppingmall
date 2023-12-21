package com.example.shoppingmall.repository;

import com.example.shoppingmall.domain.orders.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {

    Orders findOrdersByOrderToken(String orderToken);

//    List<Orders> findOrdersByUid(String uid);

}
