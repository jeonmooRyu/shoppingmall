package com.example.coupang.service.product;

import com.example.coupang.domain.product.Product;
import com.example.coupang.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    @Override
    public Product getProduct(String productCode) {
        return productRepository.findByProductCode(productCode);
    }

    @Override
    public Product registProduct(Product product) {
        return productRepository.save(product);
    }
}
