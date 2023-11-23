package com.example.coupang.domain.users;

import lombok.*;

public class UsersCommend {

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

        public Users toEntity() {
            return Users.builder()
                    .email(email)
                    .password(password)
                    .name(name)
                    .phoneNumber(phoneNumber)
                    .build();
        }
    }

}
