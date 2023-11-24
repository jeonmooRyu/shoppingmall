package com.example.coupang.interfaces.orders;

import com.example.coupang.application.OrdersFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/orders/v1")
@RequiredArgsConstructor
public class OrdersController {

    private final OrdersDtoMapper ordersDtoMapper;
    private final OrdersFacade ordersFacade;

    @PostMapping
    public @ResponseBody String registOrder(@RequestBody OrdersDto.RegistOrderRequest request) {
        var ordersDetailsCommend = request.getOrdersDetails().stream()
                .map(ordersDtoMapper::of)
                .toList();
        var commend = ordersDtoMapper.of(request, ordersDetailsCommend);
        var result = ordersFacade.registOrder(commend);
        return result.getOrderNumber();
    }

}
