package com.nedeljko.demo.dao;


import com.nedeljko.demo.model.RequestLogin;
import com.nedeljko.demo.model.ResponseMessage;
import com.nedeljko.demo.model.User;
import com.nedeljko.demo.repo.UserRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("UserDao")
@Component
public class UserDataAccessService implements UserDao, CommandLineRunner {
    //Mocked Database
    private static List<User> DB = new ArrayList<>();
    private UserRepo userRepo;

    public UserDataAccessService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User insertUser(UUID id, User user) {
        User u = new User(id, user.getName(), user.getLastName(), user.getEmail(), user.getPassword(), user.getToken());
        userRepo.save(u);
        for (User user1 : selectAllUsers()) {
            if (user1.getId().equals(id)) {
                return user1;
            }
        }
        return null;
    }

    @Override
    public List<User> selectAllUsers() {
        return (List<User>) userRepo.findAll();
    }

    @Override
    public Optional<User> selectUserById(UUID id) {
        return DB.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deleteUser(UUID id) {
        Optional<User> user = selectUserById(id);
        if (user.isEmpty()) {
            return 0;
        }
        userRepo.delete(user.get());
        return 1;
    }

    @Override
    public int updateUserById(UUID id, User user) {
        DB = selectAllUsers();
        return selectUserById(id)
                .map(p -> {
                    int indexOfPersonToUpdate = DB.indexOf(p);
                    if (indexOfPersonToUpdate >= 0) {
                        DB.set(indexOfPersonToUpdate, new User(id, user.getName(), user.getLastName(), user.getEmail(), user.getPassword(), user.getToken()));
                        userRepo.saveAll(DB);
                        return 1;
                    }
                    return 0;
                }).orElse(0);
    }

    @Override
    public User login(RequestLogin user) {
        for (User u : selectAllUsers()) {
            if (u.getEmail().equals(user.getEmail()) && u.getPassword().equals(user.getPassword())) {
                u.generateToken();
                updateUserById(u.getId(), u);
                return u;
            }
        }
        return new User();
    }

    @Override
    public ResponseMessage logout(User user) {
        for (User u : selectAllUsers()) {
            if (u.getId().equals(user.getId())) {
                u.deletToken();
                updateUserById(u.getId(), u);
                return new ResponseMessage("Logout Successfully");
            }
        }
        return new ResponseMessage("Logout Error");
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
