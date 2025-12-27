package com.example.demo.config;

import com.example.demo.security.JwtAuthenticationFilter;
import com.example.demo.security.JwtTokenProvider;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    @Bean
    public JwtTokenProvider jwtTokenProvider() {
        return new JwtTokenProvider();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            // Disable CSRF for APIs & Swagger
            .csrf(csrf -> csrf.disable())

            // Authorization rules
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(
                    "/auth/**",
                    "/swagger-ui/**",
                    "/v3/api-docs/**",
                    "/hello-servlet",
                    "/api/**"
                ).permitAll()
                .anyRequest().authenticated()
            );

        // JWT filter (kept for future security extension)
        http.addFilterBefore(
            new JwtAuthenticationFilter(jwtTokenProvider()),
            UsernamePasswordAuthenticationFilter.class
        );

        return http.build();
    }
}
