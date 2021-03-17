package com.example.restservice.repository;

import com.example.restservice.models.item.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ItemRepository extends MongoRepository<Item, String> {
}
