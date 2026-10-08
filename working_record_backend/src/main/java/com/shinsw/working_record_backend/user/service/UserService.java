package com.shinsw.working_record_backend.user.service;

import com.shinsw.working_record_backend.user.DTO.SignupRequest;
import com.shinsw.working_record_backend.user.Role;
import com.shinsw.working_record_backend.user.entity.User;
import com.shinsw.working_record_backend.user.repository.UserRepositroy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepositroy userRepo;

    public UserService(UserRepositroy userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public void signup(SignupRequest request) {
        //나중에 아이디 중복검사만따로 뺄 예정
        if(userRepo.existsById(request.getId())) {
            throw new IllegalArgumentException("이미 존재하는 아이디입니다");
        }

        User user = new User();

        user.setId(request.getId());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setUsername(request.getUsername());
        user.setRole(Role.EMPLOYEE);

        userRepo.save(user);
    }
}
