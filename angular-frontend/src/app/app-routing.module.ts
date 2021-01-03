import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CreateTutorialComponent } from './components/tutorial/create-tutorial/create-tutorial.component';
import { TutorialDetailsComponent } from './components/tutorial/tutorial-details/tutorial-details.component';
import { UpdateTutorialComponent } from './components/tutorial/update-tutorial/update-tutorial.component';
import { TutorialListComponent } from './components/tutorial/tutorial-list/tutorial-list.component';

//import doctor components into app module
import { AddDoctorComponent } from './components/doctor/add-doctor/add-doctor.component';
import {DoctorListComponent} from "./components/doctor/doctor-list/doctor-list.component";
import {DoctorDetailsComponent} from "./components/doctor/doctor-details/doctor-details.component";
import {UpdateDoctorComponent} from "./components/doctor/update-doctor/update-doctor.component";
import {SearchPageComponent} from "./components/doctor/search-page/search-page.component";
import {AddPatientComponent} from "./components/patient/add-patient/add-patient.component";

//import patient components into app module
import {PatientListComponent} from "./components/patient/patient-list/patient-list.component";
import {PatientDetailsComponent} from "./components/patient/patient-details/patient-details.component";
import {UpdatePatientComponent} from "./components/patient/update-patient/update-patient.component";

const routes: Routes = [
  //Tutorial components route here
  { path: '', redirectTo: 'tutorial', pathMatch: 'full' },
  { path: 'tutorials', component: TutorialListComponent},
  { path: 'tutorialDetails/:id', component: TutorialDetailsComponent },
  { path: 'createTutorial', component: CreateTutorialComponent },
  { path: 'updateTutorial/:id', component: UpdateTutorialComponent},

  //Doctor components route here
  { path: '', redirectTo: 'doctor', pathMatch: 'full'},
  { path: 'doctors', component: DoctorListComponent},
  { path: 'createDoctor', component: AddDoctorComponent },
  { path: 'doctorDetails/:id', component: DoctorDetailsComponent},
  { path: 'updateDoctor/:id', component: UpdateDoctorComponent},
  { path: 'searchPage', component: SearchPageComponent},

  //Patient components route here
  { path: '', redirectTo: 'patient', pathMatch: 'full'},
  { path: 'patients', component: PatientListComponent},
  { path: 'createPatient', component: AddPatientComponent },
  { path: 'patientDetails/:id', component: PatientDetailsComponent },
  { path: 'updatePatient/:id', component: UpdatePatientComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
