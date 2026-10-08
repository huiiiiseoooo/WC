package com.shinsw.working_record_backend.user.entity;

import com.shinsw.working_record_backend.user.Role;
import jakarta.persistence.*;

@Entity
@Table(name="Users")
public class User {
    @Id
    @Column(name="ID")
    private String id;

    @Column(name="NAME")
    private String username;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }


}
