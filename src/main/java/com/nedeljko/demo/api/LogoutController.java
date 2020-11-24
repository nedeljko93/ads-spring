package com.nedeljko.demo.api;

import com.nedeljko.demo.model.ResponseMessage;
import com.nedeljko.demo.model.User;
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
    public ResponseMessage logout(@RequestBody User user) {
        return userService.logOut(user);
    }
}
