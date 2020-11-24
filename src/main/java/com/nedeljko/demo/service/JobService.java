package com.nedeljko.demo.service;

import com.nedeljko.demo.dao.JobDao;
import com.nedeljko.demo.model.Job;
import com.nedeljko.demo.model.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class JobService {
    private final JobDao jobDao;

    @Autowired
    public JobService(@Qualifier("JobDao") JobDao jobDao) {
        this.jobDao = jobDao;
    }

    public ResponseMessage addJob(Job job) {
        return jobDao.addJob(job);
    }

    public List<Job> getListOfJobs() {
        return jobDao.getListOfJobs();
    }

    public ResponseMessage deleteJob(UUID id) {
        return jobDao.deleteJob(id);
    }

    public ResponseMessage updateJob(UUID id, Job job) {
        return jobDao.updateJob(id, job);
    }
}
