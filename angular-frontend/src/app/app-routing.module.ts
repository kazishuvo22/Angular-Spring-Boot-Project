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
import {SearchDoctorNameComponent} from "./components/doctor/search-doctor-name/search-doctor-name.component";
import {SearchPageComponent} from "./components/doctor/search-page/search-page.component";
import {AddPatientComponent} from "./components/patient/add-patient/add-patient.component";

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
  {path: 'doctorDetails/:id', component: DoctorDetailsComponent},
  { path: 'updateDoctor/:id', component: UpdateDoctorComponent},
  { path: 'searchPage', component: SearchPageComponent},
  { path: 'searchDoctorName/:name', component: SearchDoctorNameComponent},

  //Patient components route here
  { path: '', redirectTo: 'patient', pathMatch: 'full'},
 // { path: 'patient', component: PatientListComponent},
  { path: 'createPatient', component: AddPatientComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
