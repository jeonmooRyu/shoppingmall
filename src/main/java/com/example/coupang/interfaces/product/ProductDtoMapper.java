package com.example.coupang.interfaces.product;

import com.example.coupang.domain.product.Product;
import com.example.coupang.domain.product.ProductCommand;
import org.mapstruct.*;


@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ProductDtoMapper {

    ProductCommand.ProductRegist of(ProductDto.ProductRegistRequest request);

    ProductDto.ProductResponse toResponse(Product product);

}
