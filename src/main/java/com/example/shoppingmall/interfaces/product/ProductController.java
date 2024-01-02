package com.example.shoppingmall.interfaces.product;

import com.example.shoppingmall.application.ProductFacade;
import com.example.shoppingmall.common.Util;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product/v1")
@RequiredArgsConstructor
public class ProductController {

    private final ProductDtoMapper productDtoMapper;
    private final ProductFacade productFacade;

    @PostMapping
    public @ResponseBody String registProduct(@RequestBody ProductDto.ProductRegistRequest request) {
        var productRegistCommand = productDtoMapper.of(request);
        var result = productFacade.registProduct(productRegistCommand);
        return result.toString();
    }

    @GetMapping("/{productCode}")
    public String gotoProduct(@PathVariable String productCode, Model model) {
        var product = productFacade.getProduct(productCode);
        var reviewsDto = product.getReviews().stream().map(productDtoMapper::toReviewsResponse).toList();
        var response = productDtoMapper.toResponse(product, reviewsDto);
        model.addAttribute("product", response);
        model.addAttribute("reviews", response.getReviews());
        model.addAttribute("isLogin", Util.getUid().isPresent());
        return "product";
    }
}
