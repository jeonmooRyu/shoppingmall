package com.example.coupang.application;

import com.example.coupang.domain.users.Users;
import com.example.coupang.domain.users.UsersCommand;
import com.example.coupang.service.users.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UsersFacade {

    private final UsersService usersService;

    @Transactional
    public Users signUp(UsersCommand.SignUpRequest usersCommand) {
        var user = usersCommand.toEntity();
        return usersService.signUp(user);
    }

    @Transactional
    public Boolean isCheckDuplicateEmail(String email) {
        return usersService.isDuplicateUser(email);
    }

}
