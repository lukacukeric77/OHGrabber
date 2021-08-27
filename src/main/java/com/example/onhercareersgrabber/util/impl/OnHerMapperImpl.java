package com.example.onhercareersgrabber.util.impl;

import com.example.onhercareersgrabber.model.JobsDO;
import com.example.onhercareersgrabber.model.JobsDTO;
import com.example.onhercareersgrabber.util.OnHerMapper;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Component;

@Component
public class OnHerMapperImpl implements OnHerMapper {

    private final DozerBeanMapper mapper;

    public OnHerMapperImpl(DozerBeanMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public void mapDTOtoDO(JobsDTO jobsDTO, JobsDO jobsDO) {

        mapper.map(jobsDTO, jobsDO);

    }
}
