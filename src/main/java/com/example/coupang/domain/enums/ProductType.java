package com.example.coupang.domain.enums;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ProductType {

    FOOD("식품"),
    DIGITAL("전자기기"),
    CLOTHES("의류"),
    SPORTS("스포츠용품");

    private final String description;

}
