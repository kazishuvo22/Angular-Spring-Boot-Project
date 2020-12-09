package com.example.restservice.models.reports;

import com.example.restservice.models.medicin.Medicin;
import com.example.restservice.models.diet.Diet;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import  java.util.List;

@Document(collection = "reports")

/*
report_id
patient_id
doctor_id
created_datetime
blood_presure
pulse_rate
weight
allergies(list)
disabilities(list)
medicin(list of document)
diet(list of document)
patient_history
follow_up_doctor_id

 */
public class Report {
    @Id
    private String report_id;

    private String patient_id;
    private String doctor_id;
    private String created_datetime;
    private String blood_presure;
    private String pulse_rate;
    private String weight;
    private String allergies;
    private String disabilities;
    private List<Medicin> medicinList;
    private List<Diet> dietList;
    private String patient_history;
    private String follow_up_doctor_id;

}
