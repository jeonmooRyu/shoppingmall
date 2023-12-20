package com.example.shoppingmall.service.cart;

import com.example.shoppingmall.domain.cart.Cart;

import java.util.List;

public interface CartService {

    List<Cart> gerCarts();

    List<Cart> addCarts(List<Cart> cart);

}
