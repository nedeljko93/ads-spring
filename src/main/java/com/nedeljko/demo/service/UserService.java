package com.nedeljko.demo.service;

import com.nedeljko.demo.dao.IUserDao;
import com.nedeljko.demo.model.request.LoginRequest;
import com.nedeljko.demo.model.response.MessageResponse;
import com.nedeljko.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    private final IUserDao userDao;

    @Autowired
    public UserService(@Qualifier("UserDao") IUserDao userDao) {
        this.userDao = userDao;
    }

    public User addUser(User user) {
        return userDao.insertUser(user);
    }

    public List<User> getAllUsers() {
        return userDao.selectAllUsers();
    }

    public Optional<User> getUserByID(UUID id) {
        return userDao.selectUserById(id);
    }

    public int deletUser(UUID id) {
        return userDao.deleteUser(id);
    }

    public int updateUser(UUID id, User newUser) {
        return userDao.updateUserById(id, newUser);
    }

    public User login(LoginRequest user) {
        return userDao.login(user);
    }

    public MessageResponse logOut(User user) {
        return userDao.logout(user);
    }
}
