package com.nedeljko.demo.controller;

import com.nedeljko.demo.entity.Job;
import com.nedeljko.demo.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("api/v1/job/get")
@RestController
public class GetListOfJobsController {
    private JobService jobService;

    @Autowired
    public GetListOfJobsController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public List<Job> getListOfJobs() {
        return jobService.getListOfJobs();
    }
}
