package com.nedeljko.demo.repo;

import com.nedeljko.demo.model.Job;
import org.springframework.data.repository.CrudRepository;

public interface JobRepo extends CrudRepository<Job, Long> {

}
