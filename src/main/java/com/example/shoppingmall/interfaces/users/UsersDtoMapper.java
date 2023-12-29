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

    UsersCommand.SignUpRequest of(UsersDto.SignUpUserRequest request);

    UsersCommand.SignUpRequest of(String uid, SignUpType signUpType, String name);

    UsersDto.SignUpCheckEmailResponse toResponse(Boolean isDuplicated);
}
