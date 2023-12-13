package com.example.coupang.service.product;

import com.example.coupang.domain.product.Product;
import com.example.coupang.repository.ProductRepository;
import com.example.coupang.repository.support.ProductRepositorySupport;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    private final ProductRepositorySupport productRepositorySupport;

    @Override
    public Product getProduct(String productCode) {
        return productRepository.findByProductCode(productCode);
    }

    @Override
    public Product registProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getProducts() {
        return productRepositorySupport.getProducts();
    }
}
