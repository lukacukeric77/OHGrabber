package com.example.onhercareersgrabber.controller;

import com.example.onhercareersgrabber.service.JobService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.io.IOException;

@Controller
@RequestMapping("/")
@Slf4j
class IndexController {

    private final JobService jobService;

    public IndexController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public String frontPagePreview(){
        return "index";
    }

    @PostMapping("grabJobs")
    public String grabJobsAndProcess() throws IOException {
        jobService.getJobsFromSite();
        return "index";
    }

}
