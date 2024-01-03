package com.example.shoppingmall.repository.support;

import com.example.shoppingmall.domain.enums.ProductType;
import com.example.shoppingmall.domain.product.Product;
import static com.example.shoppingmall.domain.product.QProduct.product;
import static com.example.shoppingmall.domain.review.QReview.review;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@RequiredArgsConstructor
public class ProductRepositorySupport {

    private final JPAQueryFactory jpaQueryFactory;

    // 메인페이지 상품 조회
    public List<Product> getProducts(ProductType productType) {
        return jpaQueryFactory.selectFrom(product)
//                .limit(10)
                .where(eqProductType(productType))
                .fetch();
    }

    public BooleanExpression eqProductType(ProductType productType) {
        if (productType == null) {
            return null;
        }
        return product.productType.eq(productType);
    }

    public Product getProductByProductCode(String productCode) {
        return jpaQueryFactory.selectFrom(product)
                .leftJoin(product.reviews, review)
                .fetchJoin()
                .where(product.productCode.eq(productCode))
                .fetchOne();
    }

}
