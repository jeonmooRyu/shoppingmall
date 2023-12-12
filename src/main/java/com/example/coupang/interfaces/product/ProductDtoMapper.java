package com.example.coupang.interfaces.product;

import com.example.coupang.domain.product.Product;
import com.example.coupang.domain.product.ProductCommend;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ProductDtoMapper {

    ProductCommend.ProductRegist of(ProductDto.ProductRegistRequest request);

    ProductDto.ProductResponse toResponse(Product product);

//    @Mappings({
//            @Mapping(source = "productCode", target = "productDetails.productCode"),
//            @Mapping(source = "productName", target = "productDetails.productName"),
//            @Mapping(source = "detailImage", target = "productDetails.detailImage"),
//            @Mapping(source = "price", target = "productDetails.price")
//    })
    ProductDto.ProductResponses.ProductDetail toProductDetail(Product product);

}
