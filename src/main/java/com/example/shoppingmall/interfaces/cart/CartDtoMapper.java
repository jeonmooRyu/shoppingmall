package com.example.shoppingmall.interfaces.cart;

import com.example.shoppingmall.domain.cart.Cart;
import com.example.shoppingmall.domain.cart.CartCommand;
import org.mapstruct.*;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CartDtoMapper {

    @Mappings({
            @Mapping(source = "id", target = "cartId"),
            @Mapping(source = "cart.product.productName", target = "productName"),
            @Mapping(source = "cart.product.thumbnail", target = "thumbnail"),
            @Mapping(source = "cart.product.price", target = "price"),
            @Mapping(source = "cart.product.productCode", target = "productCode"),
    })
    CartDto.CartResponse of(Cart cart);

    CartCommand of(CartDto.AddCartRequest.CartDetail request);

    CartDto.CartResultResponse toSuccess(Boolean isSuccess);

    CartDto.CartResultResponse toFail(Boolean isSuccess);

}
