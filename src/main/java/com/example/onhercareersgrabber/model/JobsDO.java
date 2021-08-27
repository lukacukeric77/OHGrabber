package com.example.onhercareersgrabber.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table (name = "jobs")
@NoArgsConstructor
@AllArgsConstructor
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class JobsDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String jobPosition;
    private String duration;
    private String office;

}
