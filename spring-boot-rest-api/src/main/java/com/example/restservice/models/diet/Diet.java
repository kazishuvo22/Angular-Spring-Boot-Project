package com.example.restservice.models.diet;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "diet")
public class Diet {
    @Id
    private String dietid;

    private String name;
    private String description;

    public Diet() {
    }

    public Diet(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getDietid() {
        return dietid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public String toString() {
        return "Diet{" +
                "diet_id='" + dietid + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
