package com.nedeljko.demo.controller;

import com.nedeljko.demo.entity.Job;
import com.nedeljko.demo.model.response.MessageResponse;
import com.nedeljko.demo.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("api/v1/job/update")
@RestController
public class UpdateJobController {
    private JobService jobService;

    @Autowired
    public UpdateJobController(JobService jobService) {
        this.jobService = jobService;
    }

    @PutMapping(path = "/{id}")
    public MessageResponse updateJob(@PathVariable("id") UUID id, @RequestBody Job job) {
        return jobService.updateJob(id, job);
    }
}
