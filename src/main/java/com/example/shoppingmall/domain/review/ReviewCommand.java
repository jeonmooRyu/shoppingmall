package com.example.shoppingmall.domain.review;

import com.example.shoppingmall.common.Util;
import com.example.shoppingmall.domain.product.Product;
import com.example.shoppingmall.domain.users.Users;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReviewCommand {

    private String content;
    private Integer score;

    public Review toEntity(Users users, Product product) {
        var review = Review.builder()
//                .uid(Util.getUid().orElseThrow())
                .content(content)
                .score(score)
                .build();
        product.setReview(review);
        review.setUsers(users);
        return review;
    }
}
