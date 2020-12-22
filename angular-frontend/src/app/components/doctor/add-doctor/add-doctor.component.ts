import { Component, OnInit } from '@angular/core';

import { Router } from '@angular/router';
import { DoctorService } from '../../../services/doctor.service';
import { Doctor } from '../../../classes/doctor';


@Component({
  selector: 'app-add-doctor',
  templateUrl: './add-doctor.component.html',
  styleUrls: ['./add-doctor.component.css']
})
export class AddDoctorComponent implements OnInit {

  doctor:Doctor = new Doctor();
  submitted = false;

  constructor(private doctorService: DoctorService,
              private router: Router) { }

  ngOnInit(): void {
  }

  newDoctor(): void {
    this.submitted = false;
    this.doctor = new Doctor();
  }

  save() {
    this.doctorService
      .create(this.doctor).subscribe(data => {
        console.log(data);
        this.doctor = new Doctor();
        console.log(this.doctor);
        this.gotoList();
      },
      error => console.log(error));
  }

  onSubmit() {
    this.submitted = true;
    // this.tutorial.published = true;
    this.save();
  }
  gotoList() {
    this.router.navigate(['/doctors']);
  }

}
