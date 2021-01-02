import { Component, OnInit } from '@angular/core';

import { Patient } from '../../../classes/patient';
import {Observable} from "rxjs";
import {FormBuilder} from "@angular/forms";
import {PatientService} from "../../../services/patient.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-search-page',
  templateUrl: './search-page.component.html',
  styleUrls: ['./search-page.component.css']
})
export class SearchPageComponent implements OnInit {

  patients: Observable<Patient[]>;
  searchForm;
  constructor(private patientService: PatientService, private router: Router,
              private formBuilder:FormBuilder )
      {
        this.searchForm = this.formBuilder.group({
          patient_name: '',
          patient_dob:'',

    });

  }

  ngOnInit():void {
  }

  OnSubmit(searchName){
    console.log('Search Patient name and Dob:');
    console.log(searchName.patient_name);
    console.log(searchName.patient_dob);
    this.patients = this.patientService.findByPatientNameDob(searchName.patient_name, searchName.patient_dob);
  }

  patientDetails(id: string) {
    this.router.navigate(['patientDetails', id]);

  }

}
