package com.nedeljko.demo.repository;

import com.nedeljko.demo.entity.Job;
import org.springframework.data.repository.CrudRepository;

public interface JobRepo extends CrudRepository<Job, Long> {

}
