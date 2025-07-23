package com.example.identity_server.dto;

import java.time.LocalDate;

import com.example.identity_server.exception.ErrorCode;

import jakarta.validation.constraints.Size;

public class UserCreationRequest {
    @Size(min = 3, message = "USERNAME_INVALID")
    private String username;
    @Size(min = 8, message = "INVALID_PASSWORD")
    private String password;
    private String fristname;
    private String latename;
    private LocalDate dob;
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
    public String getFristname() {
        return fristname;
    }
    public void setFristname(String fristname) {
        this.fristname = fristname;
    }
    public String getLatename() {
        return latename;
    }
    public void setLatename(String latename) {
        this.latename = latename;
    }
    public LocalDate getDob() {
        return dob;
    }
    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    
}
