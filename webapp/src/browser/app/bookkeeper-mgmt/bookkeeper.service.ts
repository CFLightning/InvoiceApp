import {Injectable} from "@angular/core";
import {Observable} from "rxjs/Observable";
import {Http, Response} from "@angular/http";
import {Item} from "../_models/item";
import {Company} from "../_models/company";
import {InvoiceHead} from "../_models/invoiceHead";
import {InvoiceRow} from "../_models/invoiceRow";
@Injectable()
export class BookKeeperService {

  private backEndURL = 'http://localhost:8080/services/item/';
  private invoiceURL = 'http://localhost:8080/services/invoiceHead/';

  findAllCompanyItems(company: Company): Observable<Item[]> {
    return this.http.post(this.backEndURL + 'findCompanyItems', company)
      .map((res: Response) => {
        return res.json() as Item[];
      });
  }

  findAllCompanyInvoices(company: Company): Observable<InvoiceHead[]> {
    return this.http.post(this.invoiceURL + 'findCompanyHeaders', company)
      .map((res: Response) => {
        return res.json() as InvoiceHead[];
      });
  }

  createItem(item: Item): Observable<any> {
    return this.http.post(this.backEndURL + 'create', item);
  }

  createInvoice(invoice: InvoiceHead): Observable<any> {
    return this.http.post(this.invoiceURL + 'create', invoice);
  }

  constructor(private http: Http) { }
}

