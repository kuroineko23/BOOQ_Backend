package com.kuroneko23.bookmarket.Model;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.security.SecureRandom;

public class AccountRequest {
    private String email;
    private String password;
    public AccountRequest(String email, String password){
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
    public void setHashedPassword(String password) {
        int workFactor = 12; //how many iterations to hash the password
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(workFactor, new SecureRandom());
        this.password = encoder.encode(password);
    }
}
