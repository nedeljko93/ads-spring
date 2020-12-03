package com.nedeljko.demo.controller;

import com.nedeljko.demo.model.request.LoginRequest;
import com.nedeljko.demo.entity.User;
import com.nedeljko.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/person/login")
@RestController
public class LoginController {
    private UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User login(@RequestBody LoginRequest user) {
        return userService.login(user);
    }
}
