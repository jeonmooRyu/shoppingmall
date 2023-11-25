package com.example.coupang.common;

import java.util.UUID;

public class TokenGenerator {

    public static String generateUid() {
        var uuid = UUID.randomUUID().toString();
        return uuid.replace("-", "");
    }

}
