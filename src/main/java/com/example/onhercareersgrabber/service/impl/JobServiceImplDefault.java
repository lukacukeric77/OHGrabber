package com.example.onhercareersgrabber.service.impl;

import com.example.onhercareersgrabber.model.JobsDTO;
import com.example.onhercareersgrabber.service.JobService;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Objects;

@Service
@Slf4j
public class JobServiceImplDefault implements JobService {

    private static final String URL_FOR_GRAB = "https://www.onlineheroes.com/careers/";

    @Override
    public void getJobsFromSite() throws IOException {

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

    }
}
