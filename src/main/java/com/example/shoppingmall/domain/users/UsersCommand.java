package com.example.shoppingmall.domain.users;

import com.example.shoppingmall.domain.enums.SignUpType;
import lombok.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UsersCommand {

    @Setter
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SignUpRequest {
        private String email;
        private String password;
        private String name;
        private String phoneNumber;
        private SignUpType signUpType;
        private String uid;

        public Users toEntity() {
            return Users.builder()
                    .email(email)
                    .password(new BCryptPasswordEncoder().encode(password))
                    .name(name)
                    .phoneNumber(phoneNumber)
                    .signUpType(signUpType)
                    .build();
        }

        public Users toEntityByOath2() {
            return Users.builder()
                    .uid(uid)
                    .email(email)
                    .name(name)
                    .phoneNumber(phoneNumber)
                    .signUpType(signUpType)
                    .build();
        }
    }

}
