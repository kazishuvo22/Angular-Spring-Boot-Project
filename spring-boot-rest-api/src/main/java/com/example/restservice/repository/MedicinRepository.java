package com.example.restservice.repository;

import com.example.restservice.models.medicin.Medicin;
import org.springframework.data.mongodb.repository.MongoRepository;

    public interface MedicinRepository extends MongoRepository<Medicin, String> {

    }
