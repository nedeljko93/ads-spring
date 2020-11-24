package com.nedeljko.demo.controllers;

import com.nedeljko.demo.model.Job;
import com.nedeljko.demo.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;

@Controller
public class addJob {
    private JobService jobService;

    @Autowired
    public addJob(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping(value = "/addJob")
    public String showForm(Model model) {
        Job job = new Job();
        model.addAttribute("job", job);
        model.addAttribute("flag", true);
        return "addJob";

    }

    @PostMapping(value = "/addJob")
    public String subbmitForm(@ModelAttribute("job") Job job) {
        String timeStamp = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
        job.setDate(timeStamp);
        if (job.getRequred_level() == null) {
            job.setRequred_level("");
        }
        if (job.getCompany_email() == null) {
            job.setCompany_email("");
        }
        if (job.getIs_promoted() == null) {
            job.setIs_promoted(false);
        }
        jobService.addJob(job);
        return "addJob";

    }
}
