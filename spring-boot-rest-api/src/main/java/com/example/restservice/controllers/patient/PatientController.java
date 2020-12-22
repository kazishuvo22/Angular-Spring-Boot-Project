package com.example.restservice.controllers.patient;

import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.restservice.models.patient.Patient;
import com.example.restservice.repository.PatientRepository;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class PatientController {

    @Autowired
    PatientRepository patientRepository;

    @GetMapping("/patients")
    public ResponseEntity<List<Patient>> getAllPatients(@RequestParam(required = false) String name) {
        try {
            List<Patient> patients = new ArrayList<Patient>();

            if (name == null) {
                patientRepository.findAll().forEach(patients::add);
            }else {
                patientRepository.findByNameContaining(name).forEach(patients::add);
            }

            if (patients.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(patients, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/patients/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable("id") String id) {
        Optional<Patient> patientData = patientRepository.findById(id);

        if (patientData.isPresent()) {
            return new ResponseEntity<>(patientData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/patients/name/{name}")
    public ResponseEntity<List<Patient>>  getByPatientname(@PathVariable("name") String name) {
        List<Patient> patients = new ArrayList<Patient>();
        System.out.println(name);
        List <Patient> patientData = patientRepository.findByNameContaining(name);

        if (!patientData.isEmpty()) {
            patientRepository.findByNameContaining(name).forEach(patients::add);
            return new ResponseEntity<>(patients, HttpStatus.OK);

        } else {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/patients/dob")
    public ResponseEntity<List<Patient>>  postByPatientDob( @RequestBody Patient patient ) throws ParseException {
        List<Patient> patients = new ArrayList<Patient>();

        List<Patient> patientData = patientRepository.findByDobContaining(patient.getDob());

        if (!patientData.isEmpty()) {
            patientRepository.findByDobContaining(patient.getDob()).forEach(patients::add);
            return new ResponseEntity<>(patients, HttpStatus.OK);

        } else {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/patients/namedob")
    public ResponseEntity<Patient> postByPatientNameandDob(@RequestBody Patient patient) {
        Optional<Patient> patientData = patientRepository.findByNameContainingAndDob(patient.getName(), patient.getDob());

        if (patientData.isPresent()) {
            return new ResponseEntity<>(patientData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping("/patients")
    public ResponseEntity<Patient> createPatient(@RequestBody Patient patient) {
        try {
            Patient _patient = patientRepository.save(new Patient(
                    patient.getName(),
                    patient.getDob(),
                    patient.getAge(),
                    patient.getGender(),
                    patient.getOccupation(),
                    patient.getHealthinsuranceno(),
                    patient.getHealthcareprovider(),
                    patient.getPatientaddress(),
                    patient.getContact(),
                    patient.getDoctorid()
            ));
            return new ResponseEntity<>(_patient, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/patients/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable("id") String id, @RequestBody Patient patient) {
        Optional<Patient> patientData = patientRepository.findById(id);
        if (patientData.isPresent()) {
            Patient _patient = patientData.get();
            _patient.setName(patient.getName());
            _patient.setDob(patient.getDob());
            _patient.setAge(patient.getAge());
            _patient.setGender(patient.getGender());
            _patient.setOccupation(patient.getOccupation());
            _patient.setHealthinsuranceno(patient.getHealthinsuranceno());
            _patient.setHealthcareprovider(patient.getHealthcareprovider());
            _patient.setPatientaddress(patient.getPatientaddress());
            _patient.setContact(patient.getContact());
            _patient.setDoctorid(patient.getDoctorid());
            return new ResponseEntity<>(patientRepository.save(_patient), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/patients/{id}")
    public ResponseEntity<HttpStatus> deletePatient(@PathVariable("id") String id) {
        try {
            patientRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/patients")
    public ResponseEntity<HttpStatus> deleteAllPatients() {
        try {
            patientRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
