package com.example.coupang.service.users;

import com.example.coupang.domain.users.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
//@RequiredArgsConstructor
// 로그인을 spring security 에게 위임
public class CustomUserDetailsService implements UserDetailsService {

    private final UsersService usersService;
    private final PasswordEncoder passwordEncoder;

    public CustomUserDetailsService(UsersService usersService, PasswordEncoder passwordEncoder) {
        this.usersService = usersService;
        this.passwordEncoder = passwordEncoder;
    }

    // 로그인시 spring security 가 loadUserByUsername()로 전달해줌
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var users = usersService.getUsersByEmail(username);
        return CustomUserDetails.builder()
                .usersName(users.getUid())
                .password(users.getPassword())
                .authority(users.getAuthority())
                .build();
    }
}
