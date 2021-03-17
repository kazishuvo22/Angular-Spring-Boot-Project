import {Item} from "./item";

export class Invoice {
  id:string;
  patientid:string;
  item: Item[];
  quantity:number;
  salesprice:number;

}
