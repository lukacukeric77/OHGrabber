package com.example.onhercareersgrabber.controller;

import com.example.onhercareersgrabber.model.JobsDTO;
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

    private static final String URL_FOR_GRAB = "https://www.onlineheroes.com/careers/";

    @GetMapping
    public String frontPagePreview(){
        return "index";
    }

    @PostMapping("grabJobs")
    public String grabJobsAndProcess() throws IOException {
        // TODO: Transport in service, this does not belong in controller
        Document document = Jsoup.connect(URL_FOR_GRAB).get();
        Elements careersList = document.select(".careers-list");
        Elements articles = careersList.select("article");
        log.info("ARTICLES LIST SIZE: {}", articles.size());

        JobsDTO jobsDTO;
        for (Element element : articles){
            jobsDTO = new JobsDTO();
            jobsDTO.setJobPosition(Objects.requireNonNull(element.getElementsByTag("h1").text()));
            jobsDTO.setDuration(Objects.requireNonNull(element.getElementsByClass("careers-block__text").first()).text());
            jobsDTO.setOffice(Objects.requireNonNull(element.getElementsByClass("careers-block__text").last()).text());
            log.info("DTO: title {}, duration {}, office {}", jobsDTO.getJobPosition(), jobsDTO.getDuration(), jobsDTO.getOffice());
        }
        return "index";
    }

}
