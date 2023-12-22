package com.example.shoppingmall.domain.review;

import com.example.shoppingmall.domain.product.Product;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReviewCommand {

    private String content;
    private Integer score;

    public Review toEntity(Product product) {
        var review = Review.builder()
                .content(content)
                .score(score)
                .build();
        product.setReview(review);

        return review;
    }
}
