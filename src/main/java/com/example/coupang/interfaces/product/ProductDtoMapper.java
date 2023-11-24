package com.example.coupang.interfaces.product;

import com.example.coupang.domain.product.ProductCommend;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ProductDtoMapper {

    ProductCommend.ProductRegist of(ProductDto.ProductRegistRequest request);

}
