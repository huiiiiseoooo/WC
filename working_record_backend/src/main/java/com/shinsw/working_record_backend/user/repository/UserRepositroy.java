package com.shinsw.working_record_backend.user.repository;

import com.shinsw.working_record_backend.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositroy extends JpaRepository<User, Long> {
    boolean existsById(String id);
}
