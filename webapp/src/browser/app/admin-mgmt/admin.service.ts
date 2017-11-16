import {Injectable} from "@angular/core";
import {VatGroup} from "../_models/vatGroup";
import {Observable} from "rxjs/Observable";
import {Http, Response} from "@angular/http";
@Injectable()
export class AdminService {

  private backEndURL = 'http://localhost:8080/services/vatGroup/';

  findAllGroups(): Observable<VatGroup[]> {
    return this.http.get(this.backEndURL + 'findGroups')
      .map((res: Response) => {
        return res.json() as VatGroup[];
      });
  }

  createGroup(vatGroup: VatGroup): Observable<any> {
    return this.http.post(this.backEndURL + 'create', vatGroup);
  }

  constructor(private http: Http) { }
}
