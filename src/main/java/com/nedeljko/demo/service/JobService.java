package com.nedeljko.demo.service;

import com.nedeljko.demo.dao.IJobDao;
import com.nedeljko.demo.entity.Job;
import com.nedeljko.demo.model.response.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class JobService {

    @Value("${legenda}")
    private String myProperty;

    private final IJobDao jobDao;

    @Autowired
    public JobService(@Qualifier("JobDao") IJobDao jobDao) {
        this.jobDao = jobDao;
    }

    public MessageResponse addJob(Job job) {

        System.out.println(myProperty);

        return jobDao.addJob(job);
    }

    public List<Job> getListOfJobs() {
        return jobDao.getListOfJobs();
    }

    public MessageResponse deleteJob(UUID id) {
        return jobDao.deleteJob(id);
    }

    public MessageResponse updateJob(UUID id, Job job) {
        return jobDao.updateJob(id, job);
    }
}
