package com.example.shoppingmall.interfaces.orders;

import com.example.shoppingmall.application.OrdersFacade;
import com.example.shoppingmall.common.Util;
import com.example.shoppingmall.interfaces.payment.PaymentDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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
        var orders = ordersFacade.getOrder(orderToken);
        var response = ordersDtoMapper.toCheckoutViewDto(orders);
        model.addAttribute("order", response);
        return "checkout";
    }

    // 최초 주문등록 ( 결제전 )
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

    // 등록된 주문 결제완료 api
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
    public @ResponseBody List<OrdersDto.OrdersHistoryResponse> getOrders(@RequestParam @Nullable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                                                         @RequestParam @Nullable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        var startDateTime = startDate != null ? startDate.atStartOfDay() : null;
        var endDateTime = endDate != null ? endDate.atStartOfDay().plusDays(1) : null;
        var orders = ordersFacade.getOrders(startDateTime, endDateTime);
        return orders.stream()
                .map(ordersDtoMapper::toOrdersHistoryResponse)
                .toList();
    }


}
