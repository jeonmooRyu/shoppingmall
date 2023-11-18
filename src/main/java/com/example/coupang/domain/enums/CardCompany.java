package com.example.coupang.domain.enums;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum CardCompany {

    HYUNDAI_CARD("현대카드"),
    SAMSUNG_CARD("삼성카드"),
    LOTTE_CARD("롯데카드");

    private final String description;

}
