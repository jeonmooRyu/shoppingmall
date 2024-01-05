package com.example.shoppingmall.config;

import com.example.shoppingmall.common.Util;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

@Configuration
public class AuditingConfig implements AuditorAware{
    @Override
    public Optional<String> getCurrentAuditor() {
        return Util.getUid();
    }

}
