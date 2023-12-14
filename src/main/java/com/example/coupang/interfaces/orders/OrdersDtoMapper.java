package com.example.coupang.interfaces.orders;

import com.example.coupang.domain.orders.Orders;
import com.example.coupang.domain.orders.OrdersCommand;
import com.example.coupang.domain.payment.PaymentCommand;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrdersDtoMapper {

    OrdersCommand.RegistOrders.OrdersDetail of(OrdersDto.RegistOrderRequest.OrdersDetail ordersDetail);

    OrdersCommand.RegistOrders of(OrdersDto.RegistOrderRequest ordersDto, String uid, List<OrdersCommand.RegistOrders.OrdersDetail> ordersDetailsCommand);

    OrdersDto.RegistOrderResponse of(Orders orders);

    OrdersDto.CheckoutOrderDto toCheckoutOrders(OrdersDto.CheckoutOrderRequest request);
    PaymentCommand of(OrdersDto.CheckoutOrderRequest request);

    OrdersDto.CheckoutOrderResponse toCheckOrderResponse(Orders orders);
}
