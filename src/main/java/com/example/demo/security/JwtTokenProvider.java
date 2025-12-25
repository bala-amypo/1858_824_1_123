package com.example.demo.security;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class JwtTokenProvider {

    private static final String SECRET = "employeeSkillsSecretKey";

    public String generateToken(Long userId, String email, String role) {
        String payload = userId + "|" + email + "|" + role + "|" + System.currentTimeMillis();
        return Base64.getEncoder()
                .encodeToString((payload + SECRET).getBytes(StandardCharsets.UTF_8));
    }

    public boolean validateToken(String token) {
    try {
        String decoded = new String(
                Base64.getDecoder().decode(token),
                StandardCharsets.UTF_8
        );
        
        if (!decoded.endsWith(SECRET)) {
            return false;
        }

        String payload = decoded.substring(0, decoded.length() - SECRET.length());
        String[] parts = payload.split("\\|");

        return parts.length == 4
                && !parts[0].isBlank()
                && !parts[1].isBlank()
                && !parts[2].isBlank()
                && !parts[3].isBlank();

    } catch (Exception e) {
        return false;
    }
}

    public String getEmailFromToken(String token) {
        return decode(token)[1];
    }

    public Long getUserIdFromToken(String token) {
        return Long.parseLong(decode(token)[0]);
    }

    public String getRoleFromToken(String token) {
        return decode(token)[2];
    }

    public Map<String, Object> getClaims(String token) {
        Map<String, Object> claims = new HashMap<>();
        String[] parts = decode(token);
        claims.put("userId", Long.parseLong(parts[0]));
        claims.put("email", parts[1]);
        claims.put("role", parts[2]);
        return claims;
    }

    private String[] decode(String token) {
        String decoded = new String(
                Base64.getDecoder().decode(token),
                StandardCharsets.UTF_8
        );
        decoded = decoded.replace(SECRET, "");
        return decoded.split("\\|");
    }
}
