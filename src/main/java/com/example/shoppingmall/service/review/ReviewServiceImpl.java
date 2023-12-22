package com.example.shoppingmall.service.review;

import com.example.shoppingmall.domain.review.Review;
import com.example.shoppingmall.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService{

    private final ReviewRepository reviewRepository;

    @Override
    public Review registReview(Review review) {
        return reviewRepository.save(review);
    }
}
