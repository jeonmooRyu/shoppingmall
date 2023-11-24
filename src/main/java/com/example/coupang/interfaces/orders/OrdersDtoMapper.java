package com.example.coupang.interfaces.orders;

import com.example.coupang.domain.orders.OrdersCommend;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrdersDtoMapper {

    OrdersCommend.RegistOrders.OrdersDetail of(OrdersDto.RegistOrderRequest.OrdersDetail ordersDetail);

    OrdersCommend.RegistOrders of(OrdersDto.RegistOrderRequest ordersDto, List<OrdersCommend.RegistOrders.OrdersDetail> ordersDetailsCommend);
}
