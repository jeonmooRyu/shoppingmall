package com.example.shoppingmall.application;

import com.example.shoppingmall.domain.enums.ProductType;
import com.example.shoppingmall.domain.product.Product;
import com.example.shoppingmall.domain.product.ProductCommand;
import com.example.shoppingmall.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductFacade {

    private final ProductService productService;

    @Transactional
    public Product registProduct(ProductCommand.ProductRegist command) {
        var product = command.toEntity();
        return productService.registProduct(product);
    }

    @Transactional
    public Product getProduct(String productCode) {
        return productService.getProduct(productCode);
    }

    // 초기 노출 상품 리스트
    @Transactional
    public List<Product> getProducts(@Nullable ProductType productType, @Nullable String productName) {
        return productService.getProducts(productType, productName);
    }
}
