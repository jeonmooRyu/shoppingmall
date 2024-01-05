package com.example.shoppingmall.service.product;

import com.example.shoppingmall.domain.enums.ProductType;
import com.example.shoppingmall.domain.product.Product;
import com.example.shoppingmall.repository.ProductRepository;
import com.example.shoppingmall.repository.support.ProductRepositorySupport;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    private final ProductRepositorySupport productRepositorySupport;

    @Transactional
    public Product getProduct(String productCode) {
        return productRepositorySupport.getProductByProductCode(productCode);
    }

    @Transactional
    public Product registProduct(Product product) {
        return productRepository.save(product);
    }

    @Transactional
    public List<Product> getProducts(ProductType productType, String productName) {
        return productRepositorySupport.getProducts(productType, productName);
    }
}
