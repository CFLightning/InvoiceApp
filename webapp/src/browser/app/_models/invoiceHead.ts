import {Company} from "./company";
import {User} from "./user";
import {InvoiceRow} from "./invoiceRow";
export class InvoiceHead {
  Id: number;               //backend gen v V
  invoiceNumber: string;    //gen v V
  company: Company;         //curr v V
  issueDate: string;        //set by user v V
  buyerName: string;        //set by user v V
  buyerAddress: string;     //set by user v V
  buyerPostalCode: string;  //set by user v V
  buyerCity: string;        //set by user v V
  buyerNIP: number;         //set by user v V
  nettoTotal: number;       //row count v
  bruttoTotal: number;      //row count v
  vatTotal: number;         //row count v
  issuer: User;             //curruser v
  rows: InvoiceRow[];       //array
}
