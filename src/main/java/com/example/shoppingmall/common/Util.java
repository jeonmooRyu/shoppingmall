package com.example.shoppingmall.common;

import com.example.shoppingmall.domain.users.CustomUserDetails;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class Util {

    public static Optional<String> getUid() {
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication.getPrincipal().equals("anonymousUser")) {
            return Optional.empty();
        }
        var customUserDetails = (CustomUserDetails) authentication.getPrincipal();
        return Optional.of(customUserDetails.getUid());
    }
}
