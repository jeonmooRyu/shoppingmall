package com.example.coupang.interfaces.orders;

import com.example.coupang.application.OrdersFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/orders/v1")
@RequiredArgsConstructor
public class OrdersController {

    private final OrdersDtoMapper ordersDtoMapper;
    private final OrdersFacade ordersFacade;

    @PostMapping("/sheet")
    public String goToCheckout(@ModelAttribute OrdersDto.OrderSheetProduct products , Model model) {
        model.addAttribute("products", products);
        return "checkout";
    }

    @PostMapping
    public @ResponseBody String registOrder(@ModelAttribute OrdersDto.RegistOrderRequest request) {
        var ordersDetailsCommend = request.getOrdersDetails().stream()
                .map(ordersDtoMapper::of)
                .toList();
        var commend = ordersDtoMapper.of(request, ordersDetailsCommend);
        var result = ordersFacade.registOrder(commend);
        return result.getOrderToken();
    }

}
