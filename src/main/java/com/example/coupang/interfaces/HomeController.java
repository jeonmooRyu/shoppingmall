package com.example.coupang.interfaces;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @GetMapping("/login")
    public String goToLogin() {
        return "/login";
    }

    @GetMapping("/logout")
    public String goToLogout() {
        return "/logout";
    }

    @GetMapping("/main")
    public String goToMain() {
        return "/main";
    }
}
