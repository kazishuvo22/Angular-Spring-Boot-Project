package com.example.restservice.repository;

import java.util.List;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.restservice.models.doctor.Doctor;


public interface DoctorRepository extends MongoRepository<Doctor, String> {
   // List<Doctor> findByDoctorId(String doctor_id);
    List<Doctor> findByDoctorName(String doctor_name);
}
