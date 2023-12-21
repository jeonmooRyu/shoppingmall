package com.example.shoppingmall.domain.enums;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Option {

    S("SMALL"),
    M("MEDIUM"),
    L("LARGE"),
    XL("EXTRA-LARGE"),
    XXL("TWO-EXTRA-LARGE");

    private final String description;
}
