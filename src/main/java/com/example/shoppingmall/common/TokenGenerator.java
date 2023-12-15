package com.example.shoppingmall.common;

import org.apache.commons.lang3.RandomStringUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class TokenGenerator {

    private static final int ORDER_TOKEN_LENGTH = 18;
    private static final int PRODUCT_CODE_LENGTH = 20;
    private static final int PG_PAYMENT_ID_LENGTH = 10;


    // uid 생성
    public static String generateUid() {
        var uuid = UUID.randomUUID().toString();
        return uuid.replace("-", "");
    }

    // 주문번호 생성
    public static String generateOrderToken() {
        var prefix = LocalDate.now().format(DateTimeFormatter.ofPattern("yyMMdd"));
        return prefix + "-" + RandomStringUtils.randomNumeric(ORDER_TOKEN_LENGTH - prefix.length());
    }

    // 상품코드 생성
    public static String generateProductCode() {
        return RandomStringUtils.randomAlphanumeric(PRODUCT_CODE_LENGTH);
    }

    // PG사 결제 id 생성
    public static String generatePgId() {
        return RandomStringUtils.randomAlphanumeric(PG_PAYMENT_ID_LENGTH);
    }
}
