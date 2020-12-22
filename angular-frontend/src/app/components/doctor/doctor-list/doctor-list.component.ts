import { Component, OnInit } from '@angular/core';

import { Router } from '@angular/router';
import { DoctorService } from '../../../services/doctor.service';
import { Doctor } from '../../../classes/doctor';
import {Observable} from "rxjs";

@Component({
  selector: 'app-doctor-list',
  templateUrl: './doctor-list.component.html',
  styleUrls: ['./doctor-list.component.css']
})
export class DoctorListComponent implements OnInit {
  doctors: Observable<Doctor[]>;

  constructor(private doctorService: DoctorService, private router: Router) { }

  ngOnInit(): void {
    console.log('Doctor list');
    this.reloadData();
  }

  reloadData(){
    this.doctors = this.doctorService.getAll();
    console.log(this.doctors);
  }

  deleteDoctor(id: string) {
    this.doctorService.delete(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  doctorDetails(id: string){
    this.router.navigate(['doctorDetails', id]);
  }

  updateDoctor(id: string){
    this.router.navigate(['updateDoctor', id]);
  }

}
