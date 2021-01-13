package com.example.restservice.models.medicin;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "medicin")

public class Medicin {

    @Id
    private String medicinid;

    private String drugname;
    private String unit;
    private String dosage;

    public Medicin() {
    }

    public Medicin(String drugname, String dosage, String unit) {
        this.drugname = drugname;
        this.unit = unit;
        this.dosage = dosage;
    }

    public String getMedicinid() {
        return medicinid;
    }

    public String getDrugname() {
        return drugname;
    }

    public void setDrugname(String drugname) {
        this.drugname = drugname;
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
                "medicinid='" + medicinid + '\'' +
                ", drugname='" + drugname + '\'' +
                ", unit='" + unit + '\'' +
                ", dosage='" + dosage + '\'' +
                '}';
    }
}

