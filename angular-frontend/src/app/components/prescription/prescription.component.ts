import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { DoctorService } from '../../services/doctor.service';
import { PatientService } from '../../services/patient.service';
import { ReportService } from '../../services/report.service';
import { Doctor } from '../../classes/doctor';
import { Patient } from '../../classes/patient';
import { Report } from '../../classes/report';

@Component({
  selector: 'app-prescription',
  templateUrl: './prescription.component.html',
  styleUrls: [ './prescription.component.css' ]
})
export class PrescriptionComponent implements OnInit {

  reportId: string;
  doctor: Doctor;
  followUpDoctor: Doctor;
  patient: Patient;
  report: Report;
  currentDate = new Date();

  // date: string;

  constructor(private route: ActivatedRoute, private router: Router,
              private doctorService: DoctorService,
              private patientService: PatientService,
              private reportService: ReportService) {
  }

  ngOnInit(): void {
    this.doctor = new Doctor();
    this.followUpDoctor = new Doctor();
    this.patient = new Patient();
    this.report = new Report();
    this.currentDate = new Date();
    // this.date = this.datePipe.transform(this.currentDate, 'dd-MM-YYYY');

    this.reportId = this.route.snapshot.params['id'.toString()];
    this.reportService.get(this.reportId).subscribe(
      (reportData: Report) => {
        this.report = reportData;
        this.patientService.get(this.report.patientid).subscribe(
          (patientData: Patient) => {
            this.patient = patientData;
          }
        );
        this.doctorService.get(this.report.doctorid).subscribe(
          (doctorData: Doctor) => {
            this.doctor = doctorData;
          }
        );
        this.doctorService.get(this.report.followupdoctorid).subscribe(
          (followUpDoctorData: Doctor) => {
            this.followUpDoctor = followUpDoctorData;
          }
        );
      }
    );
  }

  cancel() {
    this.router.navigate([ 'reportDetails', this.reportId ]);
  }


}
