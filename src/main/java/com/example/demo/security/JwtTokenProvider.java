package com.example.demo.security;

import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class JwtTokenProvider {

    private final Map<String, Map<String, Object>> tokenStore = new HashMap<>();

    public String generateToken(Long userId, String email, String role) {

        String raw = userId + ":" + email + ":" + role + ":" + UUID.randomUUID();
        String token = Base64.getEncoder().encodeToString(raw.getBytes());

        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", userId);
        claims.put("email", email);
        claims.put("role", role);

        tokenStore.put(token, claims);
        return token;
    }

    public boolean validateToken(String token) {
        return tokenStore.containsKey(token);
    }

    public String getEmailFromToken(String token) {
        return tokenStore.get(token).get("email").toString();
    }

    public Long getUserIdFromToken(String token) {
        return (Long) tokenStore.get(token).get("userId");
    }

    public String getRoleFromToken(String token) {
        return tokenStore.get(token).get("role").toString();
    }

    public Map<String, Object> getClaims(String token) {
        return tokenStore.get(token);
    }
}
