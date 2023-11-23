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

//    @Mappings({
//            @Mapping(target = "email", source = "email")
//    })
    UsersCommend.signUpRequest of(UsersDto.SignUpUserRequest request);
}
