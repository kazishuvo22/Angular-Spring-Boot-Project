package com.example.restservice.controllers.invoice;

import com.example.restservice.models.invoice.Invoice;
import com.example.restservice.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class InvoiceController {

    @Autowired
    InvoiceRepository invoiceRepository;


    @GetMapping("/invoices")
    public ResponseEntity<List<Invoice>> getAllInvoices() {
        try {
            List<Invoice> invoices = new ArrayList<Invoice>();
            invoiceRepository.findAll().forEach(invoices::add);

            if (invoices.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(invoices, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/invoices")
    public ResponseEntity<Invoice> createInvoice(@RequestBody Invoice invoice) {
        try {
            Invoice _invoice = invoiceRepository.save(new Invoice(
                    invoice.getPatientid(),
                    invoice.getItem(),
                    invoice.getQuantity(),
                    invoice.getSalesprice()
            ));
            return new ResponseEntity<>(_invoice, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/invoices/{id}")
    public ResponseEntity<Invoice> updateInvoice(@PathVariable("id") String id, @RequestBody Invoice invoice) {
        Optional<Invoice> invoiceData = invoiceRepository.findById(id);

        if (invoiceData.isPresent()) {
            Invoice _invoice = invoiceData.get();

            if (invoice.getPatientid()!= null) {
                _invoice.setPatientid(invoice.getPatientid());
            }

            if (invoice.getQuantity() != null) {
                _invoice.setQuantity(invoice.getQuantity());
            }

            if (invoice.getSalesprice() != null) {
                _invoice.setSalesprice(invoice.getSalesprice());
            }


            return new ResponseEntity<>(invoiceRepository.save(_invoice), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/invoices/{id}")
    public ResponseEntity<HttpStatus> deleteInvoice(@PathVariable("id") String id) {
        try {
            invoiceRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/invoices")
    public ResponseEntity<HttpStatus> deleteAllInvoices() {
        try {
            invoiceRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/invoices/patient/{patientid}")
    public ResponseEntity<Invoice> getInvoiceByPatientId(@PathVariable("patientid") String patientid) {
        Optional<Invoice> invoiceData = invoiceRepository.findByPatientid(patientid);

        if (invoiceData.isPresent()) {
            return new ResponseEntity<>(invoiceData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
