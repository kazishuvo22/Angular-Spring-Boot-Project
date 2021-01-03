import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {Patient} from "../../../classes/patient";
import {PatientService} from "../../../services/patient.service";

@Component({
  selector: 'app-update-patient',
  templateUrl: './update-patient.component.html',
  styleUrls: ['./update-patient.component.css']
})
export class UpdatePatientComponent implements OnInit {

  id: string;
  patient: Patient;

  constructor(private route: ActivatedRoute, private router: Router,
              private patientService: PatientService) { }

  ngOnInit() {
    this.patient = new Patient();

    this.id = this.route.snapshot.params['id'];

    this.patientService.get(this.id)
      .subscribe(data => {
        console.log(data);
        this.patient = data;
      }, error => console.log(error));
  }

  updatePatient(){
    this.patientService.update(this.id, this.patient).subscribe(
      data => {
        console.log(data);
        this.patient = new Patient();
        this.list();
      }, error => console.log(error)
    );
  }

  onSubmit(){
    this.updatePatient();
  }

  list(){
    this.router.navigate(['patients']);
  }


}
