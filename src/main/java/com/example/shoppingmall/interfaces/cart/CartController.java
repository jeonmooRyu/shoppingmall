package com.example.shoppingmall.interfaces.cart;

import com.example.shoppingmall.application.CartFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequiredArgsConstructor
@RequestMapping("/cart/v1")
public class CartController {

    private final CartFacade cartFacade;
    private final CartDtoMapper cartDtoMapper;

    @GetMapping
    public String goToCart(Model model) {
        var carts = cartFacade.getCarts();
        var result =  carts.stream().map(cartDtoMapper::of).toList();
        model.addAttribute("carts", result);
        return "cart";
    }

    @PostMapping
    public @ResponseBody CartDto.CartResultResponse addToCart(@RequestBody CartDto.AddCartRequest request) {
        var commands = request.getCartDetails().stream().map(cartDtoMapper::of).toList();
        var carts = cartFacade.addCarts(commands);
        if (request.getCartDetails().size() == carts.size()) {
            return cartDtoMapper.toSuccess(true);
        }
        return cartDtoMapper.toFail(false);
    }

    @PostMapping("/delete") // 다건 일괄삭제를 위해 @DeleteMapping 대신 @PostMapping 사용
    public @ResponseBody CartDto.CartResultResponse deleteCart(@RequestBody CartDto.DeleteCartRequest request) {
        cartFacade.deleteCart(request.getCartIds());
        return cartDtoMapper.toSuccess(true);
    }





}
