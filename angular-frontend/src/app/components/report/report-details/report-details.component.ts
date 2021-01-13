import { Component, OnInit } from '@angular/core';
import {Doctor} from "../../../classes/doctor";
import {Patient} from "../../../classes/patient";
import {Report} from "../../../classes/report";
import {ActivatedRoute, Params, Router} from "@angular/router";
import {DoctorService} from "../../../services/doctor.service";
import {PatientService} from "../../../services/patient.service";
import {ReportService} from "../../../services/report.service";
import {Medicine} from "../../../classes/medicine";
import {MedicinService} from "../../../services/medicin.service";

@Component({
  selector: 'app-report-details',
  templateUrl: './report-details.component.html',
  styleUrls: ['./report-details.component.css']
})
export class ReportDetailsComponent implements OnInit {

  reportId: string;
  doctor: Doctor = new Doctor();
  followUpDoctor: Doctor = new Doctor();
  patient: Patient = new Patient();
  report: Report = new Report();

  constructor(private route: ActivatedRoute, private router: Router,
              private doctorService: DoctorService,
              private patientService: PatientService,
              private reportService: ReportService,
              ) {
  }

  ngOnInit() {
    this.doctor = new Doctor();
    this.route.params.subscribe(
      (params: Params) => {
        this.reportId = params['id'.toString()];
        this.reportService.get(this.reportId)
          .subscribe(data => {
            // get report data
            this.report = data;
            // get doctor data
            this.doctorService.get(this.report.doctorid).subscribe(
              doctorData => {
                this.doctor = doctorData;
              }
            );
            // get follow up doctor data
            this.doctorService.get(this.report.doctorid).subscribe(
              followUpDoctorData => {
                this.followUpDoctor = followUpDoctorData;
              }
            );
            // get patient data
            this.patientService.get(this.report.patientid).subscribe(
              patientData => {
                this.patient = patientData;
              }
            );
          }, error => console.log(error));
      }
    );
  }

  deleteReport(id: string) {
    this.reportService.delete(id)
      .subscribe(
        data => {
          console.log(data);
          this.reportService.sendListUpdateAlert('Deleted');
        },
        error => console.log(error));
    this.router.navigate([ 'reports' ]);
  }

  updateReport(id: string) {
    this.router.navigate([ 'updateReport', id ]);
  }
  generatePrescription(id: string) {
    this.router.navigate([ 'prescriptions', id ]);
  }

}
