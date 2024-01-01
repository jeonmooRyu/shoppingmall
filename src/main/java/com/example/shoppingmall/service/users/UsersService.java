package com.example.shoppingmall.service.users;

import com.example.shoppingmall.domain.users.Users;

public interface UsersService {

    Users signUp(Users user);

    Boolean isAlreadySignUpEmail(String email);

    Users getUsers(String uid);

    Users getUsersByEmail(String email);

    Users getUsers();

}
