package com.example.coupang.domain.enums;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Role {

    // 권한관
    COMMON("일반권한"),
    ADMIN("관리자권한");

    private final String description;
}
