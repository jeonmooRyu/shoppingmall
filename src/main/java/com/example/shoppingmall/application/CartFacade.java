package com.example.shoppingmall.application;

import com.example.shoppingmall.domain.cart.Cart;
import com.example.shoppingmall.domain.cart.CartCommand;
import com.example.shoppingmall.service.cart.CartService;
import com.example.shoppingmall.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartFacade {

    private final ProductService productService;
    private final CartService cartService;

    @Transactional
    public List<Cart> getCarts() {
        return cartService.getCarts();
    }

    @Transactional
    public List<Cart> addCarts(List<CartCommand> commands) {
        var carts = new ArrayList<Cart>();

        commands.forEach(command -> {
            var product = productService.getProduct(command.getProductCode());
            var cart = command.toEntity();
            cart.setProduct(product);
            carts.add(cart);
        });
        return cartService.addCarts(carts);
    }

    @Transactional
    public void deleteCart(List<Long> cartIds) {
        cartService.deleteCart(cartIds);
    }

}
