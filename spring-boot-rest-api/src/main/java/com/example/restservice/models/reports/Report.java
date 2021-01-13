package com.example.restservice.models.reports;

import com.example.restservice.models.diet.Diet;
import com.example.restservice.models.medicin.Medicin;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Document(collection = "reports")
public class Report {
    @Id
    private String id;
    private String patientid;
    private String doctorid;

    @CreatedDate
    private LocalDate createddate = LocalDate.now();
    private String bloodpressure;
    private Double pulserate;
    private Double weight;
    private List<String> allergies;
    private List<String> disabilities;
    private List<Medicin> medicin;
    private List<Diet> diets;
    private String patienthistory;
    private String followupdoctorid;

    public Report(String patientid, String doctorid, String bloodpressure, Double pulserate,
                  Double weight, List<String> allergies, List<String> disabilities,
                  List<Medicin> medicin, List<Diet> diets, String patienthistory, String followupdoctorid) {
        this.patientid = patientid;
        this.doctorid = doctorid;
        this.bloodpressure = bloodpressure;
        this.pulserate = pulserate;
        this.weight = weight;
        this.allergies = allergies;
        this.disabilities = disabilities;
        this.medicin = medicin;
        this.diets = diets;
        this.patienthistory = patienthistory;
        this.followupdoctorid = followupdoctorid;
    }

    public Report() {

    }

    public String getId() {
        return id;
    }

    public String getPatientid() {
        return patientid;
    }

    public void setPatientid(String patientid) {
        this.patientid = patientid;
    }

    public String getDoctorid() {
        return doctorid;
    }

    public void setDoctorid(String doctorid) {
        this.doctorid = doctorid;
    }

    public LocalDate getCreateddate() {
        return createddate;
    }

    public String getBloodpressure() {
        return bloodpressure;
    }

    public void setBloodpressure(String bloodpressure) {
        this.bloodpressure = bloodpressure;
    }

    public Double getPulserate() {
        return pulserate;
    }

    public void setPulserate(Double pulserate) {
        this.pulserate = pulserate;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public List<String> getAllergies() {
        return allergies;
    }

    public void setAllergies(List<String> allergies) {
        this.allergies = allergies;
    }

    public List<String> getDisabilities() {
        return disabilities;
    }

    public void setDisabilities(List<String> disabilities) {
        this.disabilities = disabilities;
    }

    public List<Medicin> getMedicin() {
        return medicin;
    }

    public void setMedicines(List<Medicin> medicin) {
        this.medicin = medicin;
    }

    public List<Diet> getDiets() {
        return diets;
    }

    public void setDiets(List<Diet> diets) {
        this.diets = diets;
    }

    public String getPatienthistory() {
        return patienthistory;
    }

    public void setPatienthistory(String patienthistory) {
        this.patienthistory = patienthistory;
    }

    public String getFollowupdoctorid() {
        return followupdoctorid;
    }

    public void setFollowupdoctorid(String followupdoctorid) {
        this.followupdoctorid = followupdoctorid;
    }
}