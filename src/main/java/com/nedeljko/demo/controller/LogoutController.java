package com.nedeljko.demo.controller;

import com.nedeljko.demo.model.response.MessageResponse;
import com.nedeljko.demo.entity.User;
import com.nedeljko.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/person/logout")
@RestController
public class LogoutController {

    private UserService userService;

    @Autowired
    public LogoutController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public MessageResponse logout(@RequestBody User user) {
        return userService.logOut(user);
    }
}
