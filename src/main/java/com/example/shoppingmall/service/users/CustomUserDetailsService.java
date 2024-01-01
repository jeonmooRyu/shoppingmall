package com.example.shoppingmall.service.users;

import com.example.shoppingmall.domain.users.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
// 로그인을 spring security 에게 위임
public class CustomUserDetailsService implements UserDetailsService {

    private final UsersService usersService;
    private final PasswordEncoder passwordEncoder;

    // 로그인시 spring security 가 loadUserByUsername()로 전달해줌
    // username은 고정
    // username -> email 임
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
