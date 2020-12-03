package com.example.restservice.models.doctor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "doctors")
public class Doctor {
    @Id
    private String doctor_id;

    private String doctor_name;
    private String speciality;
    private String doctor_address;
    private String hospital_name;
    private String about;
    private String profile_picture;

    public Doctor(String doctor_name, String speciality, String doctor_address,String hospital_name, String about,
                  String profile_picture) {
        this.doctor_name = doctor_name;
        this.speciality = speciality;
        this.doctor_address = doctor_address;
        this.hospital_name = hospital_name;
        this.about = about;
        this.profile_picture = profile_picture;

    }

    public String getDoctorId() {
        return doctor_id;
    }

    public String getDoctor_name() {
        return doctor_name;
    }

    public void setDoctor_name(String doctor_name) {
        this.doctor_name = doctor_name;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getDoctor_address() {
        return doctor_address;
    }

    public void setDoctor_address(String doctor_address) {
        this.doctor_address = doctor_address;
    }

    public String getHospital_name() {
        return hospital_name;
    }

    public void setHospital_name(String hospital_name) {
        this.hospital_name = hospital_name;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getProfile_picture() {
        return profile_picture;
    }

    public void setProfile_picture(String profile_picture) {
        this.profile_picture = profile_picture;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "doctor_id='" + doctor_id + '\'' +
                ", doctor_name='" + doctor_name + '\'' +
                ", speciality='" + speciality + '\'' +
                ", doctor_address='" + doctor_address + '\'' +
                ", hospital_name='" + hospital_name + '\'' +
                ", about='" + about + '\'' +
                ", profile_picture='" + profile_picture + '\'' +
                '}';
    }
}
