import {VatGroup} from "./vatGroup";
import {Company} from "./company";
export class Item {

  name : string;
  nettoPrice: number;
  bruttoPrice: number;
  unit: string;
  vatGroup: VatGroup;
  company: Company;
}
