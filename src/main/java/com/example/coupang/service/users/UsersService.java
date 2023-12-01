package com.example.coupang.service.users;

import com.example.coupang.domain.users.Users;

public interface UsersService {

    Users signUp(Users user);

    Boolean isDuplicateUser(String email);

    Users getUsersByEmail(String email);

}
