package com.example.shoppingmall.interfaces.cart;

import com.example.shoppingmall.domain.Cart;
import com.example.shoppingmall.repository.CartRepository;
import com.example.shoppingmall.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("cart/v1")
public class CartController {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private CartRepository cartRepository;

    @PostMapping
    @Transactional
    public @ResponseBody String addToCart() {
        var user = usersRepository.findById(1L).orElseThrow();
        var cart = Cart.builder()
                .user(user)
                .quantity(1)
                .productCode("testCode")
                .build();
        cartRepository.save(cart);

        return cart.getId().toString();
    }
}
