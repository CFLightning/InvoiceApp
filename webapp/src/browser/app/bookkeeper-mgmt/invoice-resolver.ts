import { Injectable } from '@angular/core';
import { Resolve, RouterStateSnapshot, ActivatedRouteSnapshot } from '@angular/router';
import { Observable } from 'rxjs';
import {BookKeeperService} from "./bookkeeper.service";
import {Item} from "../_models/item";
import {InvoiceHead} from "../_models/invoiceHead";

@Injectable()
export class InvoiceResolver implements Resolve<Array<InvoiceHead>> {

  constructor(private backend: BookKeeperService) {
  }

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<Array<InvoiceHead>> {
    if (localStorage.getItem('currentUser')) {
      var currUser = JSON.parse(localStorage.getItem('currentUser'));
      return this.backend.findAllCompanyInvoices(currUser.company);
    }
  }
}
