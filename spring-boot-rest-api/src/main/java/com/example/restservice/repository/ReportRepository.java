package com.example.restservice.repository;
import com.example.restservice.models.reports.Report;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ReportRepository extends MongoRepository<Report, String>  {
    Optional<Report> findByPatientid(String patientid);
}