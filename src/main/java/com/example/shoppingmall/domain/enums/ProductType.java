package com.example.shoppingmall.domain.enums;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ProductType {

    TOP("상의"),
    OUTER("아우터"),
    BOTTOM("하의");

    private final String description;

}
