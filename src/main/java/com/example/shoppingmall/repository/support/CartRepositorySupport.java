package com.example.shoppingmall.repository.support;

import com.example.shoppingmall.common.Util;
import com.example.shoppingmall.domain.cart.Cart;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import static com.example.shoppingmall.domain.cart.QCart.cart;
import static com.example.shoppingmall.domain.product.QProduct.product;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CartRepositorySupport {

    private final JPAQueryFactory jpaQueryFactory;

    public List<Cart> findCart() {
        return jpaQueryFactory.selectFrom(cart)
                .leftJoin(cart.product, product)
                .fetchJoin()
                .where(cart.uid.eq(Util.getUid().orElseThrow()))
                .fetch();
    }
}
