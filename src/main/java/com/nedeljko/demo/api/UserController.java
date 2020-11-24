package com.nedeljko.demo.api;

import com.nedeljko.demo.model.User;
import com.nedeljko.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/person")
@RestController
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //Add
    @PostMapping
    public User addUser(@NonNull @RequestBody User user) {
        return userService.addUser(user);
    }

    //Get ALL
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    //Get by ID
    @GetMapping(path = "/{id}")
    public User getUserByID(@PathVariable("id") UUID id) {
        return userService.getUserByID(id).orElse(null);
    }

    //Delete
    @DeleteMapping(path = "/{id}")
    public int deletUser(@PathVariable("id") UUID id) {
        return userService.deletUser(id);
    }

    //Update
    @PutMapping(path = "/{id}")
    public int updateUser(@PathVariable("id") UUID id, @NonNull @RequestBody User user) {
        return userService.updateUser(id, user);
    }
}
