package com.example.shoppingmall.application;

import com.example.shoppingmall.domain.review.Review;
import com.example.shoppingmall.domain.review.ReviewCommand;
import com.example.shoppingmall.service.product.ProductService;
import com.example.shoppingmall.service.review.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ReviewFacade {

    private final ReviewService reviewService;
    private final ProductService productService;

    @Transactional
    public Review registReview(ReviewCommand command, String productCode) {
        var product = productService.getProduct(productCode);
        var review = command.toEntity(product);
        return reviewService.registReview(review);
    }
}

