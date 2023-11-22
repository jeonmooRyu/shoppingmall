package com.example.coupang.domain.enums;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ServiceType {

    NONE("없음"),
    ROCKET_BASIC("로켓배송"),
    ROCKET_WOW("로켓와우"),
    ROCKET_FRESH("로켓프레쉬"),
    ROCKET_OVERSEAS("로켓직구");

    private final String description;
}
