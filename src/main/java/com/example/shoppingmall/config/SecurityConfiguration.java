package com.example.shoppingmall.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests((requests) -> requests
                                .requestMatchers(new AntPathRequestMatcher("/orders/v1/*")).permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/orders/v1")).permitAll()
                                .antMatchers("/*/*/*").permitAll()
                                .antMatchers("/*/*").permitAll()
                                .antMatchers("/*").permitAll()
//                        .requestMatchers("", "/home").permitAll()
                                .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                        .loginPage("/login").permitAll()
                        .loginProcessingUrl("/loginProc")
                        .defaultSuccessUrl("/main")     // "/"으로 설정시 로그인 후 기존에 접근하려던 페이지로 이동
                )
                .logout((logout) -> logout
                                .permitAll()
//                        .logoutRequestMatcher()
                                .logoutSuccessUrl("/main")
                                .invalidateHttpSession(true)
                );

        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return web -> {
            web.ignoring()
                    .antMatchers(
//                            "/orders/v1/sheet",
//                            "/orders/v1",
//                            "/product/v1"
                    );
        };
    }

//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//        return (web) -> web.ignoring().antMatchers("/resources/static/css/**");
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
