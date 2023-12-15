package com.example.shoppingmall.interfaces.users;

import com.example.shoppingmall.application.UsersFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users/v1")
@RequiredArgsConstructor
public class UsersController {

    private final UsersDtoMapper usersDtoMapper;
    private final UsersFacade usersFacade;

    // 회원가입 페이지
    @GetMapping("/signUp")
    public String goToSignUpForm() {
        return "signUp";
    }

    // 중복 회원가입 이메일로 유무 확인 api
    @PostMapping("/signUp/check")
    public @ResponseBody UsersDto.SignUpCheckEmailResponse checkDuplicateUser(@RequestBody UsersDto.SignUpCheckEmailRequest request) {
        var result = usersFacade.isCheckDuplicateEmail(request.getEmail());
        return usersDtoMapper.toResponse(result);
    }


    @PostMapping
    public String signUp(@ModelAttribute UsersDto.SignUpUserRequest request, Model model) {
        var usersCommand = usersDtoMapper.of(request);
        var user = usersFacade.signUp(usersCommand);
        model.addAttribute("user", user);
        return "/signUpSuccess";
    }

}
