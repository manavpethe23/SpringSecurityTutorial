package com.hospital.springsecuritytutorial.controller;

import com.hospital.springsecuritytutorial.dto.LoginRequestDto;
import com.hospital.springsecuritytutorial.dto.LoginResponseDto;
import com.hospital.springsecuritytutorial.dto.SignUpRequestDto;
import com.hospital.springsecuritytutorial.dto.SignupResponseDto;
import com.hospital.springsecuritytutorial.security.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto  loginRequestDto) {
            return ResponseEntity.ok(authService.login(loginRequestDto));
    }

    @PostMapping("/signup")
    public ResponseEntity<SignupResponseDto> signup(@RequestBody SignUpRequestDto signUpRequestDto) {
        return ResponseEntity.ok(authService.signup(signUpRequestDto));
    }
}
