import { Component, OnInit } from '@angular/core';
import {Doctor} from "../../../classes/doctor";
import {Patient} from "../../../classes/patient";
import {Report} from "../../../classes/report";
import {ActivatedRoute, Params, Router} from "@angular/router";
import {DoctorService} from "../../../services/doctor.service";
import {PatientService} from "../../../services/patient.service";
import {ReportService} from "../../../services/report.service";
import {Invoice} from "../../../classes/invoice";
import {InvoiceService} from "../../../services/invoice.service";

@Component({
  selector: 'app-invoice-details',
  templateUrl: './invoice-details.component.html',
  styleUrls: ['./invoice-details.component.css']
})
export class InvoiceDetailsComponent implements OnInit {


  invoiceId: string;
  doctor: Doctor = new Doctor();
  followUpDoctor: Doctor = new Doctor();
  patient: Patient = new Patient();
  invoice: Invoice = new Invoice();

  constructor(private route: ActivatedRoute, private router: Router,
              private doctorService: DoctorService,
              private patientService: PatientService,
              private invoiceService: InvoiceService,
  ) {
  }

  ngOnInit() {
    this.doctor = new Doctor();
    this.route.params.subscribe(
      (params: Params) => {
        this.invoiceId = params['id'.toString()];
        this.invoiceService.get(this.invoiceId)
          .subscribe(data => {
            this.invoice = data;
            console.log(data);

            // get patient data
            this.patientService.get(this.invoice.patientid).subscribe(
              patientData => {
                this.patient = patientData;
              }
            );
          }, error => console.log(error));
      }
    );
  }

  deleteInvoice(id: string) {
    this.invoiceService.delete(id)
      .subscribe(
        data => {
          console.log(data);
          this.invoiceService.sendListUpdateAlert('Deleted');
        },
        error => console.log(error));
    this.router.navigate(['invoices']);
  }

  updateInvoice(id: string) {
    this.router.navigate(['updateInvoice', id]);
  }

  generateInvoice(id: string) {
    this.router.navigate(['invoiceGenerate', id]);
  }

}
