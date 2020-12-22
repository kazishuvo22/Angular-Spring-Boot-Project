import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import {Tutorial} from "../../../classes/tutorial";
import {TutorialService} from "../../../services/tutorial.service";
import {Doctor} from "../../../classes/doctor";
import {DoctorService} from "../../../services/doctor.service";


@Component({
  selector: 'app-update-doctor',
  templateUrl: './update-doctor.component.html',
  styleUrls: ['./update-doctor.component.css']
})
export class UpdateDoctorComponent implements OnInit {

  id: string;
  doctor: Doctor;

  constructor(private route: ActivatedRoute, private router: Router,
              private doctorService: DoctorService) { }

  ngOnInit() {
    this.doctor = new Doctor();

    this.id = this.route.snapshot.params['id'];

    this.doctorService.get(this.id)
      .subscribe(data => {
        console.log(data);
        this.doctor = data;
      }, error => console.log(error));
  }

  updateDoctor(){
    this.doctorService.update(this.id, this.doctor).subscribe(
      data => {
        console.log(data);
        this.doctor = new Doctor();
        this.list();
      }, error => console.log(error)
    );
  }

  onSubmit(){
    this.updateDoctor();
  }

  list(){
    this.router.navigate(['doctors']);
  }

}
