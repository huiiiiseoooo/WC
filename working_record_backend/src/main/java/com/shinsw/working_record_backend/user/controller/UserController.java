package com.shinsw.working_record_backend.user.controller;

import com.shinsw.working_record_backend.user.DTO.SignupRequest;
import com.shinsw.working_record_backend.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody SignupRequest request) {
        userService.signup(request);

        return ResponseEntity.ok().build();
    }
    //TODO: 테스트 컨트롤러
    @GetMapping("/me")
    public String getCurrentUser(Authentication authentication) {
        return authentication.getName() + authentication.getAuthorities();
    }

}
