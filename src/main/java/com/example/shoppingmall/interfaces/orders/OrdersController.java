package com.example.shoppingmall.interfaces.orders;

import com.example.shoppingmall.application.OrdersFacade;
import com.example.shoppingmall.common.Util;
import com.example.shoppingmall.interfaces.payment.PaymentDtoMapper;
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
    private final PaymentDtoMapper paymentDtoMapper;
    private final OrdersFacade ordersFacade;


    @GetMapping("/{orderToken}")
    public String goToCheckout(@PathVariable String orderToken, Model model) {
        var order = ordersFacade.getOrderByOrderToken(orderToken);
        model.addAttribute("order", order);
        return "checkout";
    }

    @PostMapping
    public @ResponseBody OrdersDto.RegistOrderResponse registOrder(@RequestBody OrdersDto.RegistOrderRequest request, Model model) {
        var ordersDetailsCommand = request.getOrdersDetails().stream()
                .map(ordersDtoMapper::of)
                .toList();
        var command = ordersDtoMapper.of(request, Util.getUid().orElseThrow(), ordersDetailsCommand);
        var orders = ordersFacade.registOrder(command);
        var result = ordersDtoMapper.of(orders);
        model.addAttribute("order", result);
        return result;
    }

    @PostMapping("/checkout")
    public @ResponseBody OrdersDto.CheckoutOrderResponse checkoutOrder(@RequestBody OrdersDto.CheckoutOrderRequest request) {
        var checkoutOrder = ordersDtoMapper.toCheckoutOrders(request);
        var paymentRequest = paymentDtoMapper.of(request);
        var orders = ordersFacade.checkoutOrder(checkoutOrder, paymentRequest);
        return ordersDtoMapper.toCheckOrderResponse(orders);
    }

    @GetMapping("/complete")
    public String goToOrderComplete() {
        return "orderComplete";
    }

    @GetMapping
    public String goToOrderHistory() {
        return "orderHistory";
    }

    @GetMapping("/orderHistory")
    public @ResponseBody List<OrdersDto.OrdersHistoryResponse> getOrders() {
        var orders = ordersFacade.getOrderByUid(Util.getUid().orElseThrow());
        return orders.stream()
                .map(ordersDtoMapper::toOrdersHistoryResponse)
                .toList();
    }

}
