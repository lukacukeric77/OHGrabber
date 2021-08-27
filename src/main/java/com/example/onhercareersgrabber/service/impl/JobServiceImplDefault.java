package com.example.onhercareersgrabber.service.impl;

import com.example.onhercareersgrabber.model.JobsDO;
import com.example.onhercareersgrabber.model.JobsDTO;
import com.example.onhercareersgrabber.repository.JobRepository;
import com.example.onhercareersgrabber.service.JobService;
import com.example.onhercareersgrabber.util.OnHerMapper;
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
    private static final String CAREERS_BLOCK = "careers-block__text";
    private static final String CAREERS_LIST = ".careers-list";
    private static final String ARTICLE = "article";
    private static final String H1 = "h1";
    private final OnHerMapper mapper;
    private final JobRepository repository;

    public JobServiceImplDefault(OnHerMapper mapper, JobRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public void getJobsFromSite() throws IOException {

        Document document = Jsoup.connect(URL_FOR_GRAB).get();
        Elements careersList = document.select(CAREERS_LIST);
        Elements articles = careersList.select(ARTICLE);
        log.info("ARTICLES LIST SIZE: {}", articles.size());
        processDataAndPersist(articles);
        }



    private void processDataAndPersist(Elements articles) {
        JobsDTO jobsDTO;
        JobsDO jobsDO;
        for (Element element : articles) {
            jobsDTO = new JobsDTO();
            jobsDTO.setJobPosition(Objects.requireNonNull(element.getElementsByTag(H1).text()));
            jobsDTO.setDuration(
                Objects.requireNonNull(element.getElementsByClass(CAREERS_BLOCK).first()).text());
            jobsDTO.setOffice(
                Objects.requireNonNull(element.getElementsByClass(CAREERS_BLOCK).last()).text());
            log.info("DTO: title {}, duration {}, office {}", jobsDTO.getJobPosition(),
                jobsDTO.getDuration(), jobsDTO.getOffice());

            jobsDO = new JobsDO();
            mapper.mapDTOtoDO(jobsDTO, jobsDO);
            log.info("JOBS DO: {}, {}, {} ", jobsDO.getJobPosition(), jobsDO.getDuration(),
                jobsDO.getOffice());

            repository.save(jobsDO);
        }
    }
}
