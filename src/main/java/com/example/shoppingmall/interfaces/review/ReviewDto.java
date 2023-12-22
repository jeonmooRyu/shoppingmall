package com.example.shoppingmall.interfaces.review;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class ReviewDto {

    @Setter
    @Getter
    @ToString
    public static class RegistReviewRequest {
        private String productCode;
        private String content;
        private Integer score;
    }

    @Setter
    @Getter
    @ToString
    public static class RegistReviewResponse {
        private Boolean isSuccess;
    }
}
