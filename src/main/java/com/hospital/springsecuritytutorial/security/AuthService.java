package com.hospital.springsecuritytutorial.security;

import com.hospital.springsecuritytutorial.dto.LoginRequestDto;
import com.hospital.springsecuritytutorial.dto.LoginResponseDto;
import com.hospital.springsecuritytutorial.dto.SignUpRequestDto;
import com.hospital.springsecuritytutorial.dto.SignupResponseDto;
import com.hospital.springsecuritytutorial.entity.User;
import com.hospital.springsecuritytutorial.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final AuthUtil authUtil;
    private final UserRepository userRepository;

    public LoginResponseDto login(LoginRequestDto loginRequestDto) {
      Authentication authentication =  authenticationManager.authenticate(
          new UsernamePasswordAuthenticationToken(loginRequestDto.getUsername(), loginRequestDto.getPassword())
        );

      User user = (User) authentication.getPrincipal();
       String token = authUtil.generateAccessToken(user);
       return new LoginResponseDto(token,user.getId());
    }

    public SignupResponseDto signup(SignUpRequestDto signUpRequestDto) {
        User user = userRepository.findByUsername(signUpRequestDto.getUsername()).orElse(null);
        if (user != null) {
            throw new UsernameNotFoundException("Username already exists");
        }

      user =   userRepository.save(
                User.builder()
                        .username(signUpRequestDto.getUsername())
                        .password(signUpRequestDto.getPassword())
                .build()
        );

        return new  SignupResponseDto(user.getId(),user.getUsername());
    }
}
