import {Http, Response} from "@angular/http";
import {Injectable} from "@angular/core";
import {Company} from "../_models/company";
import {Observable} from "rxjs/Observable";

@Injectable()
export class CompanyService {
  constructor(private http: Http) {
  }

  private backEndURL = 'http://localhost:8080/services/company/';

  create(company: Company) {
    return this.http.post(this.backEndURL + 'create', company).map((response: Response) => response.json());
  }

  find(company: Company):Observable<Company> {
    return this.http.post(this.backEndURL + 'exists', company)
      .map((res: Response) => {
          let resp: Company = res.json();
          return resp;
      })
  }
}
