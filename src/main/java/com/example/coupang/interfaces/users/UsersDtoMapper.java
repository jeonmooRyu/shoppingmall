package com.example.coupang.interfaces.users;

import com.example.coupang.domain.users.UsersCommend;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(
        componentModel = "Spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface UsersDtoMapper {

    UsersCommend.SignUpRequest of(UsersDto.SignUpUserRequest request);

    UsersDto.SignUpCheckEmailResponse toResponse(Boolean isDuplicated);
}
