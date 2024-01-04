package com.example.shoppingmall.interfaces.payment;

import com.example.shoppingmall.domain.payment.PaymentCommand;
import com.example.shoppingmall.interfaces.orders.OrdersDto;
import org.mapstruct.*;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PaymentDtoMapper {

    PaymentDto.PaymentRequest of(OrdersDto.CheckoutOrderRequest request);

    @Mappings({
            @Mapping(source = "paymentRequest.totalPrice", target = "payAmount")
    })
    PaymentCommand of(PaymentDto.PaymentRequest paymentRequest, PaymentDto.PaymentResponse paymentResponse);
}
