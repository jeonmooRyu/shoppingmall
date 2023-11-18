package com.example.coupang.domain.enums;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Bank {

    SHINHAN_BANK("신한은행"),
    KOOKMIN_BANK("국민은행"),
    HANA_BANK("하나은행");

    private final String description;

}
