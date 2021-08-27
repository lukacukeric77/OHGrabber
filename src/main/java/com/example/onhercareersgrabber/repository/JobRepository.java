package com.example.onhercareersgrabber.repository;

import com.example.onhercareersgrabber.model.JobsDO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<JobsDO, Integer> {

}
