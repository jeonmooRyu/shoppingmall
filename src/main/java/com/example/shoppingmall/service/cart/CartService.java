package com.example.shoppingmall.service.cart;

import com.example.shoppingmall.domain.cart.Cart;

import java.util.List;

public interface CartService {

    List<Cart> getCarts();

    List<Cart> addCarts(List<Cart> cart);

    void deleteCart(List<Long> cartIds);

}
