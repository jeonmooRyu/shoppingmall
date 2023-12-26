package com.example.shoppingmall.interfaces.review;

import com.example.shoppingmall.application.ReviewFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/review/v1")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewDtoMapper reviewDtoMapper;
    private final ReviewFacade reviewFacade;

    @PostMapping
    public @ResponseBody ReviewDto.RegistReviewResponse registReview(@RequestBody ReviewDto.RegistReviewRequest request) {
        var command = reviewDtoMapper.of(request);
        var review = reviewFacade.registReview(command, request.getProductCode());
        return reviewDtoMapper.of(true);
    }
}
