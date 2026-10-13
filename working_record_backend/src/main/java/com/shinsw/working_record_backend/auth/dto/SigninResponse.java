package com.shinsw.working_record_backend.auth.dto;

import com.shinsw.working_record_backend.user.Role;

public class SigninResponse {
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    private String id;
    private String username;
    private Role role;
    private String token;

    public SigninResponse(String id, Role role, String username, String token) {
        this.id = id;
        this.role = role;
        this.username = username;
        this.token = token;
    }


}
