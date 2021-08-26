package com.example.onhercareersgrabber.controller;

import com.example.onhercareersgrabber.model.JobsDTO;
import com.example.onhercareersgrabber.service.JobService;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
