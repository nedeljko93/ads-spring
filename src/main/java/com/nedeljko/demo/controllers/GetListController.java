package com.nedeljko.demo.controllers;

import com.nedeljko.demo.service.JobService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class GetListController {
    private JobService jobService;
    @Autowired
    public GetListController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping(value = "/home")
    public String home(Model model) {
        model.addAttribute("jobs", jobService.getListOfJobs());
        return "home";
    }
}
