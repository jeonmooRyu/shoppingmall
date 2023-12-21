package com.example.shoppingmall.service.cart;

import com.example.shoppingmall.domain.cart.Cart;
import com.example.shoppingmall.repository.CartRepository;
import com.example.shoppingmall.repository.support.CartRepositorySupport;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final CartRepositorySupport cartRepositorySupport;

    @Override
    public List<Cart> getCarts() {
        return cartRepositorySupport.findCart();
    }

    @Transactional
    public List<Cart> addCarts(List<Cart> cart) {
        return cartRepository.saveAll(cart);
    }

    @Override
    public void deleteCart(List<Long> cartIds) {
        cartRepository.deleteAllByIdInBatch(cartIds);
    }
}
