package com.example.coupang.interfaces.users;

import com.example.coupang.domain.Cart;
import com.example.coupang.domain.Users;
import com.example.coupang.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/users/v1")
public class UsersController {

    @Autowired
    private UsersRepository usersRepository;

    @GetMapping
    @Transactional
    public @ResponseBody String test() {
        var user = usersRepository.findById(1L).orElseThrow();
        List<Cart> carts = user.getCarts();
        return user.getId().toString();
    }

    @PostMapping
    public @ResponseBody Users joinUser() {
        var user = Users.builder()
                .name("testName")
                .uid("testUid")
                .phoneNumber("testPhone")
                .build();
        usersRepository.save(user);
        return user;
    }

}
