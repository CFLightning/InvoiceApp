import {VatGroup} from "./vatGroup";
export class InvoiceRow {
  itemName: string; //
  nettoItemPrice: number; //
  bruttoItemPrice: number;
  itemUnit: string; //
  itemAmount: number; // V
  rowNettoTotal: number;
  rowBruttoTotal: number;
  vatGroup: VatGroup;
}
