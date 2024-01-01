package com.example.shoppingmall.interfaces.users;

import com.example.shoppingmall.domain.enums.SignUpType;
import com.example.shoppingmall.domain.users.UsersCommand;
import org.mapstruct.*;

@Mapper(
        componentModel = "Spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface UsersDtoMapper {

    UsersCommand of(UsersDto.SignUpUserRequest request);

    UsersCommand of(String uid, SignUpType signUpType, String name, String phoneNumber);

    UsersDto.SignUpCheckEmailResponse toResponse(Boolean isDuplicated);
}
