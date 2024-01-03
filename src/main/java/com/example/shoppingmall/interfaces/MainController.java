package com.example.shoppingmall.interfaces;

import com.example.shoppingmall.application.ProductFacade;
import com.example.shoppingmall.interfaces.product.ProductDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final ProductFacade productFacade;
    private final ProductDtoMapper productDtoMapper;

    @GetMapping("/login")
    public String goToLogin() {
        return "login";
    }

    @GetMapping("/logout")
    public String goToLogout() {
        return "logout";
    }

    @GetMapping
    public String goToMain(Model model) {
        var products = productFacade.getProducts(null);
        var result = products.stream().map(productDtoMapper::of).toList();
        model.addAttribute("products", result);
        return "main";
    }

    @GetMapping("/signUp")
    public String goToSignUp() {
        return "signUp";
    }
}
