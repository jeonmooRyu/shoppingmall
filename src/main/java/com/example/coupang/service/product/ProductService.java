package com.example.coupang.service.product;

import com.example.coupang.domain.product.Product;
import org.springframework.stereotype.Service;

public interface ProductService {

    Product getProduct(String productCode);

    Product registProduct(Product product);
}
