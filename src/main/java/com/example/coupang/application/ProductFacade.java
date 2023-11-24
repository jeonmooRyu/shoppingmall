package com.example.coupang.application;

import com.example.coupang.domain.product.Product;
import com.example.coupang.domain.product.ProductCommend;
import com.example.coupang.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductFacade {

    private final ProductRepository productRepository;

    public Product productRegist(ProductCommend.ProductRegist commend) {
        var product = commend.toEntity();
        return productRepository.save(product);
    }
}
