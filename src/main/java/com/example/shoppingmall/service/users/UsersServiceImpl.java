package com.example.shoppingmall.service.users;

import com.example.shoppingmall.domain.users.Users;
import com.example.shoppingmall.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService{

    private final UsersRepository usersRepository;

    @Override
    public Users signUp(Users user) {
        return usersRepository.save(user);
    }

    @Override
    public Boolean isDuplicateUser(String email) {
        return usersRepository.existsByEmail(email);
    }

    @Override
    public Users getUsersByEmail(String email) {
        return usersRepository.findUsersByEmail(email);
    }
}
