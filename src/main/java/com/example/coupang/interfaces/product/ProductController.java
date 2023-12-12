package com.example.coupang.interfaces.product;

import com.example.coupang.application.ProductFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/{productCode}")
    public String gotoProduct(@PathVariable String productCode, Model model) {
        var product = productFacade.getProduct(productCode);

        var response = productDtoMapper.toResponse(product);
        model.addAttribute("product", response);

//        var detail = productDtoMapper.toProductDetail(product);
//        ProductDto.ProductResponses responses = new ProductDto.ProductResponses();
//        responses.setProductDetails(List.of(detail));

        model.addAttribute("products", List.of(response));
        return "product";
    }
}
