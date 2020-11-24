package com.nedeljko.demo.api;

import com.nedeljko.demo.model.ResponseMessage;
import com.nedeljko.demo.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("api/v1/job/delete")
@RestController
public class DeleteJobController {
    private JobService jobService;

    @Autowired
    public DeleteJobController(JobService jobService) {
        this.jobService = jobService;
    }

    @DeleteMapping(path = "/{id}")
    public ResponseMessage deleteJob(@PathVariable("id") UUID id) {
        return jobService.deleteJob(id);
    }
}
