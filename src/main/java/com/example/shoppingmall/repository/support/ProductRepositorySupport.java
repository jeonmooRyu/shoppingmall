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
    public List<Product> getProducts(ProductType productType, String productName) {
        return jpaQueryFactory.selectFrom(product)
//                .limit(10)
                .where(eqProductType(productType), likeProductName(productName))    // where 절 ,(컴마)는 and 연산을 함, .and()와 같음
                .fetch();
    }

    public BooleanExpression eqProductType(ProductType productType) {
        if (productType == null) {
            return null;
        }
        return product.productType.eq(productType);
    }

    public BooleanExpression likeProductName(String productName) {
        if (productName == null) {
            return null;
        }
        return product.productName.likeIgnoreCase("%" + productName + "%");
    }

    public Product getProductByProductCode(String productCode) {
        return jpaQueryFactory.selectFrom(product)
                .leftJoin(product.reviews, review)
                .fetchJoin()
                .where(product.productCode.eq(productCode))
                .fetchOne();
    }

}
