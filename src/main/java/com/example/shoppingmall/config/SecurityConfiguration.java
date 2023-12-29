package com.example.shoppingmall.config;

import com.example.shoppingmall.service.users.OAuth2UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    private final OAuth2UserService oAuth2UserService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests((requests) -> requests
                                .requestMatchers(new AntPathRequestMatcher("/product/v1/*")).permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/product/v1")).permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/signUp")).permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/users/v1")).permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/review/v1")).permitAll()
//                                .antMatchers("/users/v1/signUp").permitAll()
//                        .requestMatchers("", "/home").permitAll()
                                .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                        .loginPage("/login").permitAll()
                        .loginProcessingUrl("/loginProc")
                        .defaultSuccessUrl("/")     // "/"으로 설정시 로그인 후 기존에 접근하려던 페이지로 이동
                )
                .logout((logout) -> logout
                                .permitAll()
//                        .logoutRequestMatcher()
                                .logoutSuccessUrl("/")
                                .invalidateHttpSession(true)
                )
                .oauth2Login((oauth2Login) -> oauth2Login
                                .loginPage("/login")
                        .authorizationEndpoint()
                        .baseUri("/oauth2/authorization")
//                        .authorizationRequestRepository()
                        .and()
                        .userInfoEndpoint()
                        .userService(oAuth2UserService)
                );
//                .and()
//                .successHandler();


        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return web -> web.ignoring()
                .antMatchers(
                        "/css/**"
                        , "/js/**"
                        , "/image/**"
                );

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
