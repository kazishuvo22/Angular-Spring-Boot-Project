package com.example.restservice.repository;

import com.example.restservice.models.diet.Diet;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DietRepository  extends MongoRepository<Diet, String> {
}
