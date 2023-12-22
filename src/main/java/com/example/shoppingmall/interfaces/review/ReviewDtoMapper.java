package com.example.shoppingmall.interfaces.review;

import com.example.shoppingmall.domain.review.ReviewCommand;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "Spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface ReviewDtoMapper {

    ReviewCommand of(ReviewDto.RegistReviewRequest request);

    ReviewDto.RegistReviewResponse of(Boolean isSuccess);
}
