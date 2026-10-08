package com.shinsw.working_record_backend.user.controller;

import com.shinsw.working_record_backend.user.DTO.SignupRequest;
import com.shinsw.working_record_backend.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
