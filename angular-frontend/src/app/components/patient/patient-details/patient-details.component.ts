import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {Patient} from "../../../classes/patient";
import {PatientService} from "../../../services/patient.service";

@Component({
  selector: 'app-patient-details',
  templateUrl: './patient-details.component.html',
  styleUrls: ['./patient-details.component.css']
})
export class PatientDetailsComponent implements OnInit {
  patient:Patient;
  id: string;

  constructor(private route:ActivatedRoute, private router:Router,
              private patientService:PatientService) { }

  ngOnInit(): void {
    this.patient = new Patient();
    this.id = this.route.snapshot.params['id'];
    this.patientService.get(this.id)
      .subscribe(data => {
        console.log(data);
        this.patient = data;
      }, error => console.log(error));
  }

  list(){
    this.router.navigate(['patients']);
  }
  updateLink(){
    this.router.navigate(['updatePatient/' + this.patient.id]);
  }

}
