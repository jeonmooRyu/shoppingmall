package com.example.coupang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CoupangApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoupangApplication.class, args);
    }

}
