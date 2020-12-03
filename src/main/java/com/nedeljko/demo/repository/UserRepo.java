package com.nedeljko.demo.repository;

import com.nedeljko.demo.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Long> {

}
