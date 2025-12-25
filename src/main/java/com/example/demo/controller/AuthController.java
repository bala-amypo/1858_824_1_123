package com.example.demo.controller;

import com.example.demo.dto.AuthLoginRequest;
import com.example.demo.dto.AuthRegisterRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.security.JwtTokenProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtTokenProvider tokenProvider;

    public AuthController(JwtTokenProvider tokenProvider) {
        this.tokenProvider = tokenProvider;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthLoginRequest request) {

        String token = tokenProvider.generateToken(
                1L,
                request.getEmail(),
                "USER"
        );

        AuthResponse response = new AuthResponse();
        response.setToken(token);
        response.setUserId(1L);
        response.setEmail(request.getEmail());
        response.setRole("USER");

        return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody AuthRegisterRequest request) {
        return ResponseEntity.ok("User registered successfully");
    }
}
