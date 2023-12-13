package com.example.coupang.interfaces.product;

import com.example.coupang.application.ProductFacade;
import com.example.coupang.interfaces.orders.OrdersDto;
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
        return result.toString();
    }

    @GetMapping("/{productCode}")
    public String gotoProduct(@PathVariable String productCode, Model model) {
        var product = productFacade.getProduct(productCode);
        var response = productDtoMapper.toResponse(product);
        model.addAttribute("product", response);
        return "product";
    }
}
