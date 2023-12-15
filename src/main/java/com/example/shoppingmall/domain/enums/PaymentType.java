package com.example.shoppingmall.domain.enums;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum PaymentType {

    CARD("카드결제"),
    ACCOUNT("계좌이체");

    private final String description;
}
