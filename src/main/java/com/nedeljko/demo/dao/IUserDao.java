package com.nedeljko.demo.dao;


import com.nedeljko.demo.model.request.LoginRequest;
import com.nedeljko.demo.model.response.MessageResponse;
import com.nedeljko.demo.entity.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IUserDao {

    User insertUser(UUID id, User user);

    default User insertUser(User user) {
        UUID id = UUID.randomUUID();
        return insertUser(id, user);
    }

    List<User> selectAllUsers();

    Optional<User> selectUserById(UUID id);

    int deleteUser(UUID id);

    int updateUserById(UUID id, User user);

    User login(LoginRequest user);

    MessageResponse logout(User user);
}
