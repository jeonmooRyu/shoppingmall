package com.example.shoppingmall.interfaces.product;

import com.example.shoppingmall.domain.product.Product;
import com.example.shoppingmall.domain.product.ProductCommand;
import com.example.shoppingmall.domain.review.Review;
import org.mapstruct.*;

import java.util.List;


@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ProductDtoMapper {

    ProductCommand.ProductRegist of(ProductDto.ProductRegistRequest request);

    @Mappings({
            @Mapping(expression = "java(product.getPrice().intValue())", target = "price")
    })
    ProductDto.ProductMainViewResponses of(Product product);

    @Mappings({
            @Mapping(source = "reviews", target = "reviews"),
            @Mapping(expression = "java(product.getPrice().intValue())", target = "price")
    })
    ProductDto.ProductResponse toResponse(Product product, List<ProductDto.ProductResponse.Review> reviews);


    @Mappings({
            @Mapping(source = "users.name", target = "userName"),
            @Mapping(source = "id", target = "reviewId"),
            @Mapping(expression = "java(review.getCreatedAt().toLocalDate())", target = "createdAt")
    })
    ProductDto.ProductResponse.Review toReviewsResponse(Review review);

}
