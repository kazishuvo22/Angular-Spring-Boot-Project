import { Component, OnInit } from '@angular/core';
import {Report} from "../../../classes/report";
import {Observable} from "rxjs";
import {Patient} from "../../../classes/patient";
import {Doctor} from "../../../classes/doctor";
import {FormArray, FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {PatientService} from "../../../services/patient.service";
import {DoctorService} from "../../../services/doctor.service";
import {ReportService} from "../../../services/report.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Medicine} from "../../../classes/medicine";
import {MedicinService} from "../../../services/medicin.service";
import {Diet} from "../../../classes/diet";
import {DietService} from "../../../services/diet.service";

@Component({
  selector: 'app-update-report',
  templateUrl: './update-report.component.html',
  styleUrls: ['./update-report.component.css']
})
export class UpdateReportComponent implements OnInit {

  report: Report = new Report();
  reportID: string;
  patientID: string;
  patients: Observable<Patient[]>;
  doctors: Observable<Doctor[]>;
  medicins: Observable<Medicine[]>;
  dietes: Observable<Diet[]>

  reportForm = this.fb.group({
    patientid: '',
    doctorid: '',
    bloodpressure: '',
    pulserate:'',
    weight: '',
    medicines: this.fb.array([ this.buildMedicine() ]),
    llergies: this.fb.array([
      this.fb.control('')
    ]),
    disabilities: this.fb.array([
      this.fb.control('')
    ]),
    diets: this.fb.array([ this.buildDiet() ]),

    patienthistory: '',
    followupdoctorid: '',
  });

  constructor(private patientService: PatientService,
              private doctorService: DoctorService,
              private reportService: ReportService,
              private medicinService: MedicinService,
              private dietService: DietService,
              private route: ActivatedRoute,
              private router: Router,
              private fb: FormBuilder) {
  }


  // Regular Component functions
  ngOnInit() {
    this.dietes = this.dietService.getAll();
    this.medicins = this.medicinService.getAll();
    this.doctors = this.doctorService.getAll();
    this.patients = this.patientService.getAll();
    this.reportID = this.route.snapshot.params['id'.toString()];
    this.reportService.get(this.reportID).subscribe(
      reportData => {
        this.report = reportData;
        this.reportForm.patchValue({
          patientid: this.report.patientid,
          doctorid: this.report.doctorid,
          bloodpressure: this.report.bloodpressure,
          pulserate: this.report.pulserate,
          weight: this.report.weight,
          patienthistory: this.report.patienthistory,
          followupdoctorid: this.report.followupdoctorid,
          medicines: this.report.mediciness,
          diets: this.report.diets
        });
      }
    );
  }

  update() {
    this.report = this.reportForm.value;
    this.reportService
      .update(this.reportID, this.report).subscribe(reportData => {
        this.report = reportData;
        console.log(this.report);
        this.gotoList();
      },
      error => console.log(error));
  }

  onSubmit() {
    this.update();
  }

  gotoList() {
    this.router.navigate([ 'reports' ]);
  }

  cancelAdd() {
    this.router.navigate([ 'reports' ]);
  }

  get medicines() {
    return this.reportForm.get('medicines') as FormArray;
  }

  addMedicins() {
    this.medicines.push(this.buildMedicine());

  }

  removeMedicins(i: number) {
    this.medicines.removeAt(i);
  }

  // Build Medicine form
  private buildMedicine(): FormGroup {
    return this.fb.group({
      drugname: [ '', Validators.required ],
      unit: [ '', Validators.required ],
      dosage: [ '', Validators.required ],
    });
  }

  get diets() {
    return this.reportForm.get('diets') as FormArray;
  }

  addDiets() {
    this.diets.push(this.buildDiet());
  }

  removeDiets(i: number) {
    this.diets.removeAt(i);
  }

  // Build Diet form
  private buildDiet(): FormGroup {
    return this.fb.group({
      dietname: [ ''],
      description: [ '' ],
    });
  }


}
