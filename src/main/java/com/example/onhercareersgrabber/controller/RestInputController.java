package com.example.onhercareersgrabber.controller;

import com.example.onhercareersgrabber.exception.JobNotFoundException;
import com.example.onhercareersgrabber.model.JobsDO;
import com.example.onhercareersgrabber.model.RestJob;
import com.example.onhercareersgrabber.service.JobService;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping(value = "/jobs", produces = MediaType.APPLICATION_JSON_VALUE)
public class RestInputController {

    private final JobService service;


    public RestInputController(JobService service) {
        this.service = service;
    }

    @GetMapping
    public CollectionModel<EntityModel<RestJob>> findAll(){
        return CollectionModel.of(service.getAllJobsFromDtbs().stream()
            .map(jobDo -> EntityModel.of(new RestJob(jobDo)))
            .collect(Collectors.toList()));
    }

    @GetMapping("{job}")
    public JobsDO findJob(@PathVariable Optional<JobsDO> job){
        if (job.isPresent()){
            return job.get();
        } else {
            throw new JobNotFoundException();
        }
    }
@ExceptionHandler(JobNotFoundException.class)
@ResponseStatus(HttpStatus.NOT_FOUND)
    public void jobNotFound(){
        // method does not need implementation, as annotations do all the work
    }

}
