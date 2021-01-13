import { Diet } from './diet';
import { Medicine } from './medicine';

export class Report {
  id: string;
  patientid: string;
  doctorid: string;
  createddate: Date;
  bloodpressure: string;
  pulserate: number;
  weight: number;
  allergies: string[];
  disabilities: string[];
  mediciness: Medicine[];
  diets: Diet[];
  patienthistory: string;
  followupdoctorid: string;
}
