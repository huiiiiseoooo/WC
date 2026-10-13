package com.shinsw.working_record_backend.auth.service;

import com.shinsw.working_record_backend.user.entity.User;
import com.shinsw.working_record_backend.user.repository.UserRepositroy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



@Service
public class AuthService {
    private final UserRepositroy userRepo;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepositroy userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public User signin(String id, String password){
        User user = userRepo.findById(id).orElseThrow(
                ()->new IllegalArgumentException("사용자를 찾을 수 없습니다")
        );
        if(passwordEncoder.matches(password,user.getPassword())){
            return user;
        }else{
            throw new IllegalArgumentException("비밀번호가 틀립니다");
        }
    }
}
