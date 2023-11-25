package com.example.coupang.common;

import com.example.coupang.domain.enums.ProductType;
import com.example.coupang.service.orders.OrdersService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class TokenGenerator {

    private static final int ORDER_TOKEN_LENGTH = 18;


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
}
