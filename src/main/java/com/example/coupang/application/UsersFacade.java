package com.example.coupang.application;

import com.example.coupang.domain.users.Users;
import com.example.coupang.domain.users.UsersCommend;
import com.example.coupang.service.users.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UsersFacade {

    private final UsersService usersService;

    @Transactional
    public Users signUp(UsersCommend.signUpRequest usersCommend) {
        var user = usersCommend.toEntity();
        return usersService.signUp(user);
    }

}
