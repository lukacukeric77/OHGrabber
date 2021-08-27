package com.example.onhercareersgrabber.model;


import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RestJob {

    private Integer id;
    private String jobPosition;
    private String duration;
    private String office;

    public RestJob(JobsDO jobsDO) {
        this.id = jobsDO.getId();
        this.jobPosition = jobsDO.getJobPosition();
        this.duration = jobsDO.getDuration();
        this.office = jobsDO.getOffice();
    }
}
