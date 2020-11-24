package com.nedeljko.demo.dao;


import com.nedeljko.demo.model.RequestLogin;
import com.nedeljko.demo.model.ResponseMessage;
import com.nedeljko.demo.model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserDao {

    User insertUser(UUID id, User user);

    default User insertUser(User user) {
        UUID id = UUID.randomUUID();
        return insertUser(id, user);
    }

    List<User> selectAllUsers();

    Optional<User> selectUserById(UUID id);

    int deleteUser(UUID id);

    int updateUserById(UUID id, User user);

    User login(RequestLogin user);

    ResponseMessage logout(User user);
}
