package com.example.restservice.models.invoice;

import com.example.restservice.models.item.Item;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "invoice")
public class Invoice {
    @Id
    private String id;
    private String patientid;
    private List<Item[]> item;
    private Integer quantity;
    private Integer salesprice;

    public Invoice() {

    }

    public Invoice(String patientid, List<Item[]> item, Integer quantity, Integer salesprice) {
        this.patientid = patientid;
        this.item = item;
        this.quantity = quantity;
        this.salesprice = salesprice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPatientid() {
        return patientid;
    }

    public void setPatientid(String patientid) {
        this.patientid = patientid;
    }

    public List<Item[]> getItem() {
        return item;
    }

    public void setItem(List<Item[]> item) {
        this.item = item;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getSalesprice() {
        return salesprice;
    }

    public void setSalesprice(Integer salesprice) {
        this.salesprice = salesprice;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id='" + id + '\'' +
                ", patientid='" + patientid + '\'' +
                ", item=" + item +
                ", quantity=" + quantity +
                ", salesprice=" + salesprice +
                '}';
    }
}
