package com.example.restservice.models.medicin;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "medicin")

public class Medicin {

    @Id
    private String medicin_id;

    private String drug_name;
    private String unit;
    private String dosage;

    public Medicin() {
    }

    public Medicin(String medicin_id, String drug_name, String unit, String dosage) {
        this.medicin_id = medicin_id;
        this.drug_name = drug_name;
        this.unit = unit;
        this.dosage = dosage;
    }

    public String getMedicin_id() {
        return medicin_id;
    }

    public void setMedicin_id(String medicin_id) {
        this.medicin_id = medicin_id;
    }

    public String getDrug_name() {
        return drug_name;
    }

    public void setDrug_name(String drug_name) {
        this.drug_name = drug_name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }


    @Override
    public String toString() {
        return "Medicin{" +
                "medicin_id='" + medicin_id + '\'' +
                ", drug_name='" + drug_name + '\'' +
                ", unit='" + unit + '\'' +
                ", dosage='" + dosage + '\'' +
                '}';
    }
}

