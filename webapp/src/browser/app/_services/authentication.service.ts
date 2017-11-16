import { Injectable } from '@angular/core';
import { Http, Headers, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map'
import {User} from "../_models/user";

@Injectable()
export class AuthenticationService {
  constructor(private http: Http) { }

  currentUser: User;

  private backEndURL = 'http://localhost:8080/services/user/';

  login(username: string, password: string) {
    this.currentUser = new User();
    this.currentUser.login = username;
    this.currentUser.password = password;

    return this.http.post(this.backEndURL + 'findUserByLogin', this.currentUser)
      .map((response: Response) => {
        // login successful if there's a jwt token in the response
        let user = response.json();
        if (user && user.token) {
          // store user details and jwt token in local storage to keep user logged in between page refreshes
          localStorage.setItem('currentUser', JSON.stringify(user));
        }
      });
  }

  logout() {
    // remove user from local storage to log user out
    localStorage.removeItem('currentUser');
  }
}
