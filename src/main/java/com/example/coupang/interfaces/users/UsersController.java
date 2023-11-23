package com.example.coupang.interfaces.users;

import com.example.coupang.application.UsersFacade;
import com.example.coupang.domain.users.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/users/v1")
@RequiredArgsConstructor
public class UsersController {

    private final UsersDtoMapper usersDtoMapper;
    private final UsersFacade usersFacade;


    @PostMapping
    public @ResponseBody String signUp(@RequestBody UsersDto.SignUpUserRequest request) {
        var usersCommend = usersDtoMapper.of(request);
        var result = usersFacade.signUp(usersCommend);
        return result.toString();
    }

}
