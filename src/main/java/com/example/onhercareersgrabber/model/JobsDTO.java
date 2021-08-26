package com.example.onhercareersgrabber.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class JobsDTO {

    private String jobPosition;
    private String duration;
    private String office;

}
