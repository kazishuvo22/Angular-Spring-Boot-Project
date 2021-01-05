import { Diet } from './diet';
import { Medicine } from './medicine';

export class Report {
  id: string;
  patientid: string;
  doctorid: string;
  createddate: Date;
  bloodpressure: number;
  pulserate: number;
  weight: number;
  allergies: string[];
  disabilities: string[];
  medicines: Medicine[];
  diets: Diet[];
  patienthistory: string;
  followupdoctorid: string;
}
