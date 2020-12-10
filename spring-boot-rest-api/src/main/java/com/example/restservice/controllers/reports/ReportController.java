package com.example.restservice.controllers.reports;

import com.example.restservice.models.patient.Patient;
import com.example.restservice.models.reports.Report;
import com.example.restservice.repository.PatientRepository;
import com.example.restservice.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ReportController {

    @Autowired
    ReportRepository reportRepository;

    @GetMapping("/reports")
    public ResponseEntity<List<Report>> getAllReports() {
        try {
            List<Report> reports = new ArrayList<Report>();
            reportRepository.findAll().forEach(reports::add);

            if (reports.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(reports, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/reports/{id}")
    public ResponseEntity<Report> getReportById(@PathVariable("id") String id) {
        Optional<Report> reportData = reportRepository.findById(id);

        if (reportData.isPresent()) {
            return new ResponseEntity<>(reportData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/reports/patient/{patientid}")
    public ResponseEntity<Report> getReportByPatientId(@PathVariable("patientid") String patientid) {
        Optional<Report> reportData = reportRepository.findByPatientid(patientid);

        if (reportData.isPresent()) {
            return new ResponseEntity<>(reportData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Autowired
    PatientRepository patientRepository;

    @PostMapping("/reports/namedob")
    public ResponseEntity<Report> getReportByPatientNameandDob(@RequestBody Patient p) {
        Optional<Patient> patientData = patientRepository.findByNameContainingAndDob(p.getName(), p.getDob());
        if (patientData.isPresent()) {
            Patient patient = patientData.get();
            Optional<Report> reportData = reportRepository.findByPatientid(patient.getId());
            if (reportData.isPresent()) {
                return new ResponseEntity<>(reportData.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping("/reports")
    public ResponseEntity<Report> createReport(@RequestBody Report report) {
        try {
            Report _report = reportRepository.save(new Report(
                    report.getPatientid(),
                    report.getDoctorid(),
                    report.getBloodpressure(),
                    report.getPulserate(),
                    report.getWeight(),
                    report.getAllergies(),
                    report.getDisabilities(),
                    report.getMedicin(),
                    report.getDiets(),
                    report.getPatienthistory(),
                    report.getFollowupdoctorid()
            ));
            return new ResponseEntity<>(_report, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/reports/{id}")
    public ResponseEntity<Report> updatePatient(@PathVariable("id") String id, @RequestBody Report report) {
        Optional<Report> reportData = reportRepository.findById(id);

        if (reportData.isPresent()) {
            Report _report = reportData.get();

            if (report.getPatientid() != null) {
                _report.setPatientid(report.getPatientid());
            }

            if (report.getBloodpressure() != null) {
                _report.setBloodpressure(report.getBloodpressure());
            }

            if (report.getPulserate() != null) {
                _report.setPulserate(report.getPulserate());
            }

            if (report.getWeight() != null) {
                _report.setWeight(report.getWeight());
            }

            if (report.getAllergies() != null) {
                _report.setAllergies(report.getAllergies());
            }

            if (report.getDisabilities() != null) {
                _report.setDisabilities(report.getDisabilities());
            }

            if (report.getMedicin() != null) {
                _report.setMedicines((report.getMedicin()));
            }

            if (report.getDiets() != null) {
                _report.setDiets(report.getDiets());
            }

            if (report.getPatienthistory() != null) {
                _report.setPatienthistory(report.getPatienthistory());
            }

            if (report.getFollowupdoctorid() != null) {
                _report.setFollowupdoctorid(report.getFollowupdoctorid());
            }

            return new ResponseEntity<>(reportRepository.save(_report), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/reports/{id}")
    public ResponseEntity<HttpStatus> deletePatient(@PathVariable("id") String id) {
        try {
            reportRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/reports")
    public ResponseEntity<HttpStatus> deleteAllPatients() {
        try {
            reportRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}