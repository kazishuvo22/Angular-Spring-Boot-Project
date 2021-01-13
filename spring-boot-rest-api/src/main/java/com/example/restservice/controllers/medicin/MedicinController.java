package com.example.restservice.controllers.medicin;

import com.example.restservice.models.medicin.Medicin;
import com.example.restservice.repository.MedicinRepository;
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


public class MedicinController {

    @Autowired
    MedicinRepository medicinRepository;

    @GetMapping("/medicins")
    public ResponseEntity<List<Medicin>> getAllMedicine() {
        try {
            List<Medicin> medicins = new ArrayList<Medicin>();
            medicinRepository.findAll().forEach(medicins::add);

            if (medicins.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(medicins, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/medicins/{medicinid}")
    public ResponseEntity<Medicin> getMedicinById(@PathVariable("medicinid") String medicinid) {
        Optional<Medicin> medicinData = medicinRepository.findById(medicinid);

        if (medicinData.isPresent()) {
            return new ResponseEntity<>(medicinData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/medicins")
    public ResponseEntity<Medicin> createMedicin(@RequestBody Medicin medicin) {
        try {
            Medicin _medicin = medicinRepository.save(new Medicin(
                    medicin.getDrugname(),
                    medicin.getDosage(),
                    medicin.getUnit()
            ));
            return new ResponseEntity<>(_medicin, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/medicins/{id}")
    public ResponseEntity<HttpStatus> deleteMedicin(@PathVariable("id") String id) {
        try {
            medicinRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
