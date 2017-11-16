import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions, Response } from '@angular/http';
import {User} from "../_models/user";
import {Company} from "../_models/company";



@Injectable()
export class UserService {
  constructor(private http: Http) { }

  private backEndURL = 'http://localhost:8080/services/user/';

  create(user: User) {
    return this.http.post(this.backEndURL + 'create', user).map((response: Response) => response.json());
  }

  find(user: User) {
    return this.http.post(this.backEndURL + 'exists', user)
      .map((res: Response) => {
        let resp: User = res.json();
        return resp;
      })
  }

  findByCompany(company: Company){
    return this.http.post(this.backEndURL + 'findByCompany', company)
      .map((res: Response) => {
        return res.json() as User[];
      });
  }

  // private helper methods

  private jwt() {
    // create authorization header with jwt token
    let currentUser = JSON.parse(localStorage.getItem('currentUser'));
    if (currentUser && currentUser.token) {
      let headers = new Headers({ 'Authorization': 'Bearer ' + currentUser.token });
      return new RequestOptions({ headers: headers });
    }
  }
}
