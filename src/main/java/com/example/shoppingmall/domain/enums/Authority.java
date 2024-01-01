package com.example.shoppingmall.domain.enums;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Authority {

    // 권한관
    ROLE_COMMON("일반권한"),
    ROLE_ADMIN("관리자권한");

    private final String description;
}
