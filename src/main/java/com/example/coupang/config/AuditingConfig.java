package com.example.coupang.config;

import com.example.coupang.common.Util;
import com.example.coupang.domain.users.CustomUserDetails;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

@Configuration
public class AuditingConfig implements AuditorAware{
    @Override
    public Optional<String> getCurrentAuditor() {
        return Util.getUid();
//        var authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (authentication == null || authentication.getPrincipal().equals("anonymousUser")) {
//            return Optional.empty();
//        }
//        var customUserDetails = (CustomUserDetails) authentication.getPrincipal();
//        return Optional.of(customUserDetails.getUsername());
    }

}
