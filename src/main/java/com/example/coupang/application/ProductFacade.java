package com.example.coupang.application;

import com.example.coupang.domain.product.Product;
import com.example.coupang.domain.product.ProductCommend;
import com.example.coupang.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductFacade {

    private final ProductService productService;

    public Product registProduct(ProductCommend.ProductRegist commend) {
        var product = commend.toEntity();
        return productService.registProduct(product);
    }

    public Product getProduct(String productCode) {
        return productService.getProduct(productCode);
    }

    // 초기 노출 상품 리스트
    public List<Product> getMainProducts() {
        return productService.getProducts();
    }
}
