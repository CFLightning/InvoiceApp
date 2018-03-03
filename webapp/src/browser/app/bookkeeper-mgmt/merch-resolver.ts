import { Injectable } from '@angular/core';
import { Resolve, RouterStateSnapshot, ActivatedRouteSnapshot } from '@angular/router';
import { Observable } from 'rxjs';
import {BookKeeperService} from "./bookkeeper.service";
import {Item} from "../_models/item";

@Injectable()
export class MerchResolver implements Resolve<Array<Item>> {

  constructor(private backend: BookKeeperService) {
  }

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<Array<Item>> {
    if (localStorage.getItem('currentUser')) {
      var currUser = JSON.parse(localStorage.getItem('currentUser'));
      return this.backend.findAllCompanyItems(currUser.company);
    }
  }
}
