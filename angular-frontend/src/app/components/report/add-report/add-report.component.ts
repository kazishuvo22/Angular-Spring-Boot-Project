import { Component, OnInit } from '@angular/core';
import {FormArray, FormBuilder, FormGroup, Validators} from "@angular/forms";
import { Report } from '../../../classes/report';
import { Patient } from '../../../classes/patient';
import { Doctor} from "../../../classes/doctor";
import { DoctorService} from "../../../services/doctor.service";
import { PatientService} from "../../../services/patient.service";
import { ReportService } from "../../../services/report.service";
import {Observable} from "rxjs";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-add-report',
  templateUrl: './add-report.component.html',
  styleUrls: ['./add-report.component.css']
})
export class AddReportComponent implements OnInit {

  report: Report = new Report();
  submitted = false;
  reportID: string;
  patientID: string;
  patients: Observable<Patient[]>;
  doctors: Observable<Doctor[]>;
  patient: Patient;

  reportForm = this.fb.group({
    patientid: [ '', Validators.required ],
    doctorid: [ '', Validators.required ],
    bloodpressure: [ '', Validators.required ],
    pulserate: [ '', Validators.required ],
    weight: [ '', Validators.required ],
    allergies: this.fb.array([
      this.fb.control('')
    ]),
    disabilities: this.fb.array([
      this.fb.control('')
    ]),
    medicines: this.fb.array([ this.Medicine() ]),
    diets: this.fb.array([ this.Diet()]),
    patienthistory: [ '', Validators.required ],
    followupdoctorid: [ '', Validators.required ]
  });

  constructor(private patientService: PatientService,
              private doctorService: DoctorService,
              private reportService: ReportService,
              private route: ActivatedRoute,
              private router: Router,
              private fb: FormBuilder) {
  }


  get allergies() {
    return this.reportForm.get('allergies') as FormArray;
  }

  get disabilities() {
    return this.reportForm.get('disabilities') as FormArray;
  }

  get medicines() {
    return this.reportForm.get('medicines') as FormArray;
  }

  get diets() {
    return this.reportForm.get('diets') as FormArray;
  }


  ngOnInit() {
    this.doctors = this.doctorService.getAll();
    this.patients = this.patientService.getAll();
    this.patientID = this.route.snapshot.params['id'.toString()];
    console.log(this.patientID);
    this.patient = new Patient();
    try {
      this.patientService.get(this.patientID).subscribe(
        patientData => {
          this.patient = patientData;
          this.reportForm.patchValue({
            patientid: this.patient.id,
            doctorid: this.patient.doctorid
          });
          console.log(this.patient);
        }
      );
    } catch ( e ) {
      console.log('Failed to load patient data');
    }
  }

  save() {
    this.report = this.reportForm.value;
    this.reportService
      .create(this.report).subscribe(reportData => {
        this.report = reportData;
        this.reportID = this.report.id;
        this.report = new Report();
        this.reportService.sendListUpdateAlert('Added');
        this.gotoList();
      },
      error => console.log(error));
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }

  gotoList() {
    this.router.navigate([ 'reports', this.reportID ]);
  }

  cancelAdd() {
    this.router.navigate([ 'reports' ]);
  }

  // Build Medicine form
  private Medicine(): FormGroup {
    return this.fb.group({
      drugname: [ '', Validators.required ],
      unit: [ '', Validators.required ],
      dosage: [ '', Validators.required ],
    });
  }

  // Build Diet form
  private Diet(): FormGroup {
    return this.fb.group({
      dietname: [ '', Validators.required ],
      description: [ '', Validators.required ],
    });
  }

}
