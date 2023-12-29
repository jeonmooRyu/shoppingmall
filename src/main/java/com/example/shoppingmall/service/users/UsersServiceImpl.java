package com.example.shoppingmall.service.users;

import com.example.shoppingmall.common.Util;
import com.example.shoppingmall.domain.users.Users;
import com.example.shoppingmall.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService{

    private final UsersRepository usersRepository;

    @Transactional
    public Users signUp(Users user) {
        return usersRepository.save(user);
    }

    @Transactional
    public Boolean isAlreadySignUpEmail(String email) {
        return usersRepository.existsByEmail(email);
    }

    @Transactional
    public Users getUsers(String uid) {
        return usersRepository.findByUid(uid);
    }

    @Transactional
    public Users getUsersByEmail(String email) {
        return usersRepository.findUsersByEmail(email);
    }

    @Override
    public Users getUsers() {
        return usersRepository.findByUid(Util.getUid().orElseThrow());
    }
}
