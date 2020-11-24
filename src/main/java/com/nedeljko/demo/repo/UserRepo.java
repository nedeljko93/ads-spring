package com.nedeljko.demo.repo;

import com.nedeljko.demo.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Long> {

}
