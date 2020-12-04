package com.example.restservice.repository;

import java.util.List;

import com.example.restservice.models.doctor.Doctor;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface DoctorRepository extends MongoRepository<Doctor, String> {
    List<Doctor> findByDoctornameContaining(String doctorname);
}
