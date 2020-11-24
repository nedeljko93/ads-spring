package com.nedeljko.demo.dao;


import com.nedeljko.demo.model.Job;
import com.nedeljko.demo.model.ResponseMessage;

import java.util.List;
import java.util.UUID;

public interface JobDao {

    ResponseMessage addJob(UUID id, Job job);

    default ResponseMessage addJob(Job job) {
        UUID id = UUID.randomUUID();
        return addJob(id, job);
    }

    List<Job> getListOfJobs();

    ResponseMessage deleteJob(UUID id);

    ResponseMessage updateJob(UUID id, Job job);
}
