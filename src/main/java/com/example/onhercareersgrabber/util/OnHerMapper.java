package com.example.onhercareersgrabber.util;

import com.example.onhercareersgrabber.model.JobsDO;
import com.example.onhercareersgrabber.model.JobsDTO;

public interface OnHerMapper {

    void mapDTOtoDO(JobsDTO jobsDTO, JobsDO jobsDO);

}
