package com.example.shoppingmall.interfaces.users;

import com.example.shoppingmall.domain.users.UsersCommand;
import org.mapstruct.*;

@Mapper(
        componentModel = "Spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface UsersDtoMapper {

    UsersCommand.SignUpRequest of(UsersDto.SignUpUserRequest request);

    UsersDto.SignUpCheckEmailResponse toResponse(Boolean isDuplicated);
}
