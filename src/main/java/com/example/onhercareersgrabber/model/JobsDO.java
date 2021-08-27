package com.example.onhercareersgrabber.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table (name = "jobs")
@NoArgsConstructor
@AllArgsConstructor
public class JobsDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String jobPosition;
    private String duration;
    private String office;

}
