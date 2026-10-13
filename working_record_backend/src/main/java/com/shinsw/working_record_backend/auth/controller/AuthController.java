package com.shinsw.working_record_backend.auth.controller;

import com.shinsw.working_record_backend.auth.dto.SigninRequest;
import com.shinsw.working_record_backend.auth.dto.SigninResponse;
import com.shinsw.working_record_backend.auth.jwt.JwtService;
import com.shinsw.working_record_backend.auth.service.AuthService;

import com.shinsw.working_record_backend.user.entity.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;
    private final JwtService jwtService;

    public AuthController(AuthService authService, JwtService jwtService) {
        this.authService = authService;
        this.jwtService = jwtService;
    }

    @PostMapping("/signin")
    public SigninResponse signin(@RequestBody SigninRequest signinRequest) {
        User user = authService.signin(signinRequest.getId(), signinRequest.getPassword());

        SigninResponse signinResponse = new SigninResponse(
                user.getId(), user.getRole(), user.getUsername(), jwtService.provideJwt(user)
        );

        return signinResponse;
    }
}
