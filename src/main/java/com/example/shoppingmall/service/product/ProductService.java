package com.example.shoppingmall.service.product;

import com.example.shoppingmall.domain.enums.ProductType;
import com.example.shoppingmall.domain.product.Product;

import java.util.List;

public interface ProductService {

    Product getProduct(String productCode);

    Product registProduct(Product product);

    List<Product> getProducts(ProductType productType);
}
