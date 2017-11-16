import { Injectable } from '@angular/core';
import { Resolve, RouterStateSnapshot, ActivatedRouteSnapshot } from '@angular/router';
import { Observable } from 'rxjs';
import {User} from "../_models/user";
import {UserService} from "../_services/user.service";

@Injectable()
export class EmployeeResolver implements Resolve<Array<User>> {

  constructor(private backend: UserService) {
  }

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<Array<User>> {
    if (localStorage.getItem('currentUser')) {
      var currUser = JSON.parse(localStorage.getItem('currentUser'));
      return this.backend.findByCompany(currUser.company);
    }
  }
}
