package com.example.shoppingmall.service.users;

import com.example.shoppingmall.domain.users.Users;

public interface UsersService {

    Users signUp(Users user);

    Boolean isDuplicateUser(String email);

    Users getUsersByEmail(String email);

}
