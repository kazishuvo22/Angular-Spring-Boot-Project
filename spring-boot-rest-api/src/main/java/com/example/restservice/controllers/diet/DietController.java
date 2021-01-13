package com.example.restservice.controllers.diet;

import com.example.restservice.models.diet.Diet;
import com.example.restservice.repository.DietRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api")


public class DietController {

    @Autowired
    DietRepository dietRepository;

    @GetMapping("/diets")
    public ResponseEntity<List<Diet>> getAllDiet() {
        try {
            List<Diet> diets = new ArrayList<Diet>();
            dietRepository.findAll().forEach(diets::add);

            if (diets.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(diets, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/diets/{dietid}")
    public ResponseEntity<Diet> getDietById(@PathVariable("dietid") String dietid) {
        Optional<Diet> dietData = dietRepository.findById(dietid);

        if (dietData.isPresent()) {
            return new ResponseEntity<>(dietData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/diets")
    public ResponseEntity<Diet> createDiet(@RequestBody Diet diet) {
        try {
            Diet _diet = dietRepository.save(new Diet(
                    diet.getName(),
                    diet.getDescription()
            ));
            return new ResponseEntity<>(_diet, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/diets/{dietid}")
    public ResponseEntity<HttpStatus> deleteDiet(@PathVariable("dietid") String dietid) {
        try {
            dietRepository.deleteById(dietid);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/diets")
    public ResponseEntity<HttpStatus> deleteAllDiets() {
        try {
            dietRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
