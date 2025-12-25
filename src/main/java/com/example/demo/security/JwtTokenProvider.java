package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

public class JwtTokenProvider {

    private static final Key SECRET_KEY =
            Keys.hmacShaKeyFor("verySecretKeyForJwtEmployeeSkillMatrixSearch".getBytes());

    private static final long EXPIRATION_TIME = 86400000; // 1 day

    public String generateToken(Long userId, String email, String role) {

        return Jwts.builder()
                .setSubject(email)
                .claim("userId", userId)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SECRET_KEY, SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            getClaims(token);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public String getEmailFromToken(String token) {
        return getClaims(token).getSubject();
    }

    public Long getUserIdFromToken(String token) {
        Object val = getClaims(token).get("userId");
        if (val instanceof Integer) {
            return ((Integer) val).longValue();
        }
        return (Long) val;
    }

    public String getRoleFromToken(String token) {
        Object role = getClaims(token).get("role");
        return role != null ? role.toString() : null;
    }
}
