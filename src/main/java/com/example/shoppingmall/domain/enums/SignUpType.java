package com.example.shoppingmall.domain.enums;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum SignUpType {

    COMMON("일반 회원가입"),
    KAKAO("카카오 회원가입");

    private final String description;
}
