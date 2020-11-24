package com.nedeljko.demo.api;

import com.nedeljko.demo.model.Job;
import com.nedeljko.demo.model.ResponseMessage;
import com.nedeljko.demo.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/job/add")
@RestController
public class AddJobController {
    private JobService jobService;

    @Autowired
    public AddJobController(JobService jobService) {
        this.jobService = jobService;
    }

    @PostMapping
    public ResponseMessage addJob(@RequestBody Job job) {
        return jobService.addJob(job);
    }
}
