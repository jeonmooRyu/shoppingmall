package com.example.coupang.interfaces;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/login")
    public String goToLogin() {
        return "login";
    }

    @GetMapping("/logout")
    public String goToLogout() {
        return "logout";
    }

    @GetMapping("/main")
    public String goToMain() {
        return "main";
    }

    @GetMapping("/sign-up")
    public String goToSignUp() {
        return "signUp";
    }
}
