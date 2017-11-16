import { Injectable } from '@angular/core';
import { Resolve, RouterStateSnapshot, ActivatedRouteSnapshot } from '@angular/router';
import { Observable } from 'rxjs';
import {UserService} from "../_services/user.service";
import {User} from "../_models/user";
import {AdminService} from "./admin.service";
import {VatGroup} from "../_models/vatGroup";

@Injectable()
export class VatGroupResolver implements Resolve<Array<VatGroup>> {

  constructor(private backend: AdminService) {
  }

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<Array<VatGroup>> {
    return this.backend.findAllGroups();
  }
}
