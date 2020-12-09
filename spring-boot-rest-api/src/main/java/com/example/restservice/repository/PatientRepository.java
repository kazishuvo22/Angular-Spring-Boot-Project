package com.example.restservice.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.example.restservice.models.patient.Patient;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PatientRepository extends MongoRepository<Patient, String> {
    List<Patient> findByNameContaining(String name);

    List<Patient> findByDobContaining(Date dob);

    Optional<Patient> findByNameContainingAndDob(String name, Date dob);
}
