import { Component, OnInit } from '@angular/core';

import {ActivatedRoute, Router} from '@angular/router';
import { DoctorService } from '../../../services/doctor.service';
import { Doctor } from '../../../classes/doctor';
import {Observable} from "rxjs";

@Component({
  selector: 'app-search-page',
  templateUrl: './search-page.component.html',
  styleUrls: ['./search-page.component.css']
})
export class SearchPageComponent implements OnInit {

  doctors: Observable<Doctor[]>;

  constructor(private doctorService: DoctorService, private router: Router,private route: ActivatedRoute,) { }
  doctor:Doctor = new Doctor();
  submitted = false;
  doctorname: string;


  ngOnInit():void {
  }

  onSubmit():void{
    this.doctor = new Doctor();

    this.doctorname = this.route.snapshot.params['doctorname'];

    this.doctorService.get(this.doctorname)
      .subscribe(data => {
        console.log(data);
        this.doctor = data;
      }, error => console.log(error));
  }


  doctorDetails(doctorname: string) {
    this.router.navigate(['doctorDetails',doctorname]);
  }
}
