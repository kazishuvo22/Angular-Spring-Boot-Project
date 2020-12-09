package com.example.restservice.models.diet;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "diet")
public class Diet {
    @Id
    private String diet_id;

    private String name;
    private String descrption;

    public Diet() {
    }

    public Diet(String diet_id, String name, String descrption) {
        this.diet_id = diet_id;
        this.name = name;
        this.descrption = descrption;
    }

    public String getDietid() {
        return diet_id;
    }

    public void setDiet_id(String diet_id) {
        this.diet_id = diet_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return descrption;
    }

    public void setDescrption(String descrption) {
        this.descrption = descrption;
    }


    @Override
    public String toString() {
        return "Diet{" +
                "diet_id='" + diet_id + '\'' +
                ", name='" + name + '\'' +
                ", descrption='" + descrption + '\'' +
                '}';
    }
}
