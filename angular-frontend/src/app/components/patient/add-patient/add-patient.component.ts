import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PatientService } from '../../../services/patient.service';
import { Patient } from '../../../classes/patient';
import { Doctor } from '../../../classes/doctor';
import { DoctorService } from '../../../services/doctor.service';
import {Observable} from "rxjs";

@Component({
  selector: 'app-add-patient',
  templateUrl: './add-patient.component.html',
  styleUrls: ['./add-patient.component.css']
})
export class AddPatientComponent implements OnInit {

  patient:Patient = new Patient();
  submitted = false;
  doctors: Observable<Doctor[]>;

  constructor(private patientService: PatientService, private doctorService: DoctorService,
              private router: Router) { }

  ngOnInit(): void {
    this.doctors = this.doctorService.getAll();
  }

  newPatient(): void {
    this.submitted = false;
    this.patient = new Patient();
  }

  save() {
    this.patientService
      .create(this.patient).subscribe(data => {
        console.log(data);
        this.patient = new Patient();
        console.log(this.patient);
        this.gotoList();
      },
      error => console.log(error));
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }
  gotoList() {
    this.router.navigate(['patients']);
  }

}
