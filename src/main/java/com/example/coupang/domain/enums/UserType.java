package com.example.coupang.domain.enums;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum UserType {

    MEMBER_COMMON("일반회원"),
    MEMBER_WOW("쿠팡와우회원");

    private final String description;

}
