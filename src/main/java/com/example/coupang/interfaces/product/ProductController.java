package com.example.coupang.interfaces.product;

import com.example.coupang.application.ProductFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/product/v1")
@RequiredArgsConstructor
public class ProductController {

    private final ProductDtoMapper productDtoMapper;
    private final ProductFacade productFacade;

    @PostMapping
    public @ResponseBody String registProduct(@RequestBody ProductDto.ProductRegistRequest request) {
        var productRegistCommend = productDtoMapper.of(request);
        var result = productFacade.registProduct(productRegistCommend);
        return request.toString();
    }
}
