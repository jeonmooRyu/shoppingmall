package com.example.coupang.interfaces.payment;

import com.example.coupang.domain.payment.PaymentCommand;
import com.example.coupang.interfaces.orders.OrdersDto;
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
