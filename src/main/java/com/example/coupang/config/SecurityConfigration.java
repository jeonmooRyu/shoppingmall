package com.example.coupang.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.web.SecurityFilterChain;

@Configuration
//@EnableWebSecurity
public class SecurityConfigration {

//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf(Customizer.withDefaults())    // 사이트간 위조 요청 방지
//                .authorizeHttpRequests(authorize -> authorize
//                        .anyRequest().authenticated()
//                )
//                .httpBasic(Customizer.withDefaults())
//                .formLogin(Customizer.withDefaults());
//        return http.build();
//
//    }

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.csrf().disable();
//
//        // 기본 설정인 Session 방식 사용하지 않고 JWT 방식 사용
//        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//
//        http.authorizeRequests().antMatchers("/api/user/**").permitAll()
//                .antMatchers(HttpMethod.GET, "/api/posts").permitAll()
//                .antMatchers(HttpMethod.GET, "/api/post/{id}").permitAll()
//                .anyRequest().authenticated();
////                .and().addFilterBefore(new JwtAuthFilter(jwtUtil), UsernamePasswordAuthenticationFilter.class);
//
//        http.formLogin().permitAll();
//
//        return http.build();
//    }

//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.csrf().disable();
////        http.authorizeRequests()
////                .antMatchers("/user/**").authenticated()
////                // .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN') or
////                // hasRole('ROLE_USER')")
////                // .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN') and
////                // hasRole('ROLE_USER')")
////                .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
////                .anyRequest().permitAll()
////                .and()
////                .formLogin()
////                .loginPage("/login")
////                .loginProcessingUrl("/loginProc")
////                .defaultSuccessUrl("/");
//////                .and()
//////                .oauth2Login()
//////                .loginPage("/login")
//////                .userInfoEndpoint();
//////                .userService(principalOauth2UserService);
//
//        return http.build();
//    }

}
