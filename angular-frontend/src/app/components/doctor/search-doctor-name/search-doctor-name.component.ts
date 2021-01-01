import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {Doctor} from "../../../classes/doctor";
import {DoctorService} from "../../../services/doctor.service";

@Component({
  selector: 'app-search-doctor-name',
  templateUrl: './search-doctor-name.component.html',
  styleUrls: ['./search-doctor-name.component.css']
})
export class SearchDoctorNameComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  onSubmit() {

  }
}
