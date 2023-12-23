package com.example.shoppingmall.repository;

import com.example.shoppingmall.domain.review.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
