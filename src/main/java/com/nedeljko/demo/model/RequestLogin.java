package com.nedeljko.demo.model;

public class RequestLogin {
    private String email;
    private String password;


    public RequestLogin(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
