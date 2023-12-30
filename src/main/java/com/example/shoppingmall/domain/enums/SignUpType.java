package com.example.shoppingmall.domain.enums;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum SignUpType {

    COMMON("일반 회원가입"),
    KAKAO("카카오 회원가입"),
    NAVER("네이버 회원가입"),
    GOOGLE("구글 회원가입");

    private final String description;
}
