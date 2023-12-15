package com.example.shoppingmall.interfaces.payment;

import com.example.shoppingmall.domain.payment.PaymentCommand;
import com.example.shoppingmall.interfaces.orders.OrdersDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PaymentDtoMapper {

    PaymentDto.PaymentRequest of(OrdersDto.CheckoutOrderRequest request);

    PaymentCommand of(PaymentDto.PaymentRequest paymentRequest, PaymentDto.PaymentResponse paymentResponse);
}
