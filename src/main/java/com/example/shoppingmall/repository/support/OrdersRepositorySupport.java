package com.example.shoppingmall.repository.support;

import com.example.shoppingmall.common.Util;
import com.example.shoppingmall.domain.orders.Orders;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

import static com.example.shoppingmall.domain.orders.QOrders.orders;
import static com.example.shoppingmall.domain.orders.QOrdersDetail.ordersDetail;
import static com.example.shoppingmall.domain.payment.QPayment.payment;

@Repository
@RequiredArgsConstructor
public class OrdersRepositorySupport {

    private final JPAQueryFactory jpaQueryFactory;

    public Orders findOrdersByOrderToken(String orderToken) {
        return jpaQueryFactory.selectFrom(orders)
                .leftJoin(orders.ordersDetails, ordersDetail)
                .fetchJoin()
                .where(orders.orderToken.eq(orderToken))
                .fetchOne();
    }

    public List<Orders> findOrders(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        return jpaQueryFactory.selectFrom(orders)
                .distinct()
                .leftJoin(orders.ordersDetails, ordersDetail)
                .fetchJoin()
                .leftJoin(orders.payment, payment)
                .fetchJoin()
                .where(
                        orders.uid.eq(Util.getUid().orElseThrow()),
                        orders.isPay.eq(true),
                        hasDate(startDateTime, endDateTime)
                )
                .orderBy(orders.createdAt.desc())
                .fetch();
    }

    public BooleanExpression hasDate(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        if (endDateTime != null) {
            if (startDateTime != null) {
                return orders.createdAt.between(startDateTime, endDateTime);
            }
            return orders.createdAt.before(endDateTime);
        }
        return null;
    }

}
