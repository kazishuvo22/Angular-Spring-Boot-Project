package com.example.restservice.models.item;

import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "item")
public class Item {

    @Id
    private String id;

    private Integer itemno;
    private String itemname;
    private String testsortname;
    private String samname;
    private Integer unitprice;

    public Item() {
    }

    public Item(Integer itemno, String itemname, String testsortname, String samname, Integer unitprice) {
        this.itemno = itemno;
        this.itemname = itemname;
        this.testsortname = testsortname;
        this.samname = samname;
        this.unitprice = unitprice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getItemno() {
        return itemno;
    }

    public void setItemno(Integer itemno) {
        this.itemno = itemno;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public String getTestsortname() {
        return testsortname;
    }

    public void setTestsortname(String testsortname) {
        this.testsortname = testsortname;
    }

    public String getSamname() {
        return samname;
    }

    public void setSamname(String samname) {
        this.samname = samname;
    }

    public Integer getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(Integer unitprice) {
        this.unitprice = unitprice;
    }
}
