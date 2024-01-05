package com.example.shoppingmall.interfaces.orders;

import com.example.shoppingmall.domain.orders.Orders;
import com.example.shoppingmall.domain.orders.OrdersCommand;
import com.example.shoppingmall.domain.payment.PaymentCommand;
import org.mapstruct.*;

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

    OrdersDto.CheckoutViewResponse toCheckoutViewDto(Orders orders);

    OrdersDto.CheckoutOrderResponse toCheckOrderResponse(Orders orders);

    @Mappings({
            @Mapping(expression = "java(orders.getTotalPrice().intValue())", target = "totalPrice")
    })
    OrdersDto.OrdersHistoryResponse toOrdersHistoryResponse(Orders orders);
}
