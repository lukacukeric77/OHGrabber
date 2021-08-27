package com.example.onhercareersgrabber.service;

import com.example.onhercareersgrabber.model.JobsDO;
import java.io.IOException;
import java.util.List;

public interface JobService {

    void getJobsFromSite() throws IOException;
    List<JobsDO> getAllJobsFromDtbs();

}
