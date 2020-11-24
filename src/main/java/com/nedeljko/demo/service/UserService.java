package com.nedeljko.demo.service;

import com.nedeljko.demo.dao.UserDao;
import com.nedeljko.demo.model.RequestLogin;
import com.nedeljko.demo.model.ResponseMessage;
import com.nedeljko.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    private final UserDao userDao;

    @Autowired
    public UserService(@Qualifier("UserDao") UserDao userDao) {
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

    public User login(RequestLogin user) {
        return userDao.login(user);
    }

    public ResponseMessage logOut(User user) {
        return userDao.logout(user);
    }
}
