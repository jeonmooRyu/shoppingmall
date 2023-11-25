package com.example.coupang.application;

import com.example.coupang.domain.product.Product;
import com.example.coupang.domain.product.ProductCommend;
import com.example.coupang.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductFacade {

    private final ProductService productService;

    public Product registProduct(ProductCommend.ProductRegist commend) {
        var product = commend.toEntity();
        return productService.registProduct(product);
    }
}
