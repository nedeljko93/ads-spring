package com.nedeljko.demo.dao;


import com.nedeljko.demo.entity.Job;
import com.nedeljko.demo.model.response.MessageResponse;

import java.util.List;
import java.util.UUID;

public interface IJobDao {

    MessageResponse addJob(UUID id, Job job);

    default MessageResponse addJob(Job job) {
        UUID id = UUID.randomUUID();
        return addJob(id, job);
    }

    List<Job> getListOfJobs();

    MessageResponse deleteJob(UUID id);

    MessageResponse updateJob(UUID id, Job job);
}
