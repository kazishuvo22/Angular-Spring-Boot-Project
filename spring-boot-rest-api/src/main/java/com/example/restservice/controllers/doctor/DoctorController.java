package com.example.restservice.controllers.doctor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.restservice.models.doctor.Doctor;
import com.example.restservice.repository.DoctorRepository;

@RestController
@RequestMapping("/api")
public class DoctorController {

    @Autowired
    DoctorRepository doctorRepository;

    @GetMapping("/doctors")
    public ResponseEntity<List<Doctor>> getAllDoctors(@RequestParam(required = false) String doctorname) {
        try {
            List<Doctor> doctors = new ArrayList<Doctor>();

            if (doctorname == null) {
                doctorRepository.findAll().forEach(doctors::add);
            }else {
                doctorRepository.findByDoctornameContaining(doctorname).forEach(doctors::add);
            }

            if (doctors.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(doctors, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/doctors/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable("id") String id) {
        Optional<Doctor> doctorData = doctorRepository.findById(id);

        if (doctorData.isPresent()) {
            return new ResponseEntity<>(doctorData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/doctors/name/{doctorname}")
    public ResponseEntity<List<Doctor>>  getDoctorByDoctorname(@PathVariable("doctorname") String doctorname) {
        List<Doctor> doctors = new ArrayList<Doctor>();
        List <Doctor> doctorData = doctorRepository.findByDoctornameContaining(doctorname);

        if (!doctorData.isEmpty()) {
            doctorRepository.findByDoctornameContaining(doctorname).forEach(doctors::add);
            return new ResponseEntity<>(doctors, HttpStatus.OK);

        } else {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/doctors")
    public ResponseEntity<Doctor> createDoctor(@RequestBody Doctor doctor) {
        try {
            Doctor _doctor = doctorRepository.save(new Doctor(
                    doctor.getDoctorname(),
                    doctor.getSpeciality(),
                    doctor.getDoctor_address(),
                    doctor.getHospital_name(),
                    doctor.getAbout(),
                    doctor.getProfile_picture()
            ));
            return new ResponseEntity<>(_doctor, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/doctors/{id}")
    public ResponseEntity<Doctor> updateDoctor(@PathVariable("id") String id, @RequestBody Doctor doctor) {
        Optional<Doctor> doctorData = doctorRepository.findById(id);

        if (doctorData.isPresent()) {
            Doctor _doctor = doctorData.get();
            _doctor.setDoctorname(doctor.getDoctorname());
            _doctor.setSpeciality(doctor.getSpeciality());
            _doctor.setDoctor_address(doctor.getDoctor_address());
            _doctor.setHospital_name(doctor.getHospital_name());
            _doctor.setAbout(doctor.getAbout());
            _doctor.setProfile_picture(doctor.getProfile_picture());
            return new ResponseEntity<>(doctorRepository.save(_doctor), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/doctors/{id}")
    public ResponseEntity<HttpStatus> deleteDoctor(@PathVariable("id") String id) {
        try {
            doctorRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/doctors")
    public ResponseEntity<HttpStatus> deleteAllDoctors() {
        try {
            doctorRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}

