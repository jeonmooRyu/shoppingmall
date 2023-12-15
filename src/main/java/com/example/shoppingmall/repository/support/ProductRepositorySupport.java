package com.example.shoppingmall.repository.support;

import com.example.shoppingmall.domain.product.Product;
import static com.example.shoppingmall.domain.product.QProduct.product;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@RequiredArgsConstructor
public class ProductRepositorySupport {

    private final JPAQueryFactory jpaQueryFactory;

    public List<Product> getProducts() {
        return jpaQueryFactory.selectFrom(product)
                .limit(10)
                .fetch();
    }

}
