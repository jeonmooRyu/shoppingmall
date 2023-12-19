package com.example.shoppingmall.repository.support;

import com.example.shoppingmall.common.Util;
import com.example.shoppingmall.domain.orders.Orders;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.shoppingmall.domain.orders.QOrders.orders;
import static com.example.shoppingmall.domain.orders.QOrdersDetail.ordersDetail;
import static com.example.shoppingmall.domain.payment.QPayment.payment;

@Repository
@RequiredArgsConstructor
public class OrdersRepositorySupport {

    private final JPAQueryFactory jpaQueryFactory;

    public List<Orders> findOrders() {
        return jpaQueryFactory.selectFrom(orders)
                .distinct()
                .leftJoin(orders.ordersDetails, ordersDetail)
                .fetchJoin()
                .leftJoin(orders.payment, payment)
                .fetchJoin()
                .where(orders.uid.eq(Util.getUid().orElseThrow()))
                .orderBy(orders.createdAt.desc())
                .fetch();
    }
}
