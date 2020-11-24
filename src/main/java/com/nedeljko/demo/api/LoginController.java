package com.nedeljko.demo.api;

import com.nedeljko.demo.model.RequestLogin;
import com.nedeljko.demo.model.User;
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
    public User login(@RequestBody RequestLogin user) {
        return userService.login(user);
    }
}
