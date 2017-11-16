import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {AlertService} from "../_services/alert.service";
import {UserService} from "../_services/user.service";
import {NavbarService} from "../general/navigation/app-nav.service";
import {CompanyService} from "../_services/company.service";
import {User} from "../_models/user";
import {Company} from "../_models/company";
import any = jasmine.any;
import {Observable} from "rxjs/Observable";



@Component({
  moduleId: module.id,
  templateUrl: 'register.component.html'
})

export class RegisterComponent implements OnInit {
  user: any = {};
  company: any = {};
  loading = false;
  userOk: boolean = false;
  companyOk: boolean = false;
  done: boolean = false;
  obsCompany: any;
  obsUser: any;
  error: any = false;

  constructor(
    private router: Router,
    private userService: UserService,
    private companyService: CompanyService,
    private alertService: AlertService,
    private nav: NavbarService) { }

  ngOnInit(){
    this.nav.hide();
    this.obsCompany = this.companyService.find(this.company);
    this.obsUser = this.userService.find(this.user);
  }

  checkUser() {
    let tempUser: User;
    this.obsUser
      .subscribe((data: User) => {
        tempUser = data;
        if(tempUser.login != this.user.login){
          this.userOk = true;
          this.registerUser();
        } else {
          this.alertService.error('Nazwa użytkownika zajęta');
          this.error = true;
        }
      });
  }

  registerUser() {
    if(this.userOk && this.companyOk){
      this.companyService.create(this.company)
      this.user.company = this.company;
      this.user.accountType = 2;
      this.userService.create(this.user)
        .subscribe(
          data => {
            this.alertService.success('Rejestracja zakończona powodzeniem', true);
            this.router.navigate(['login']);
          },
          error => {
            this.alertService.error(error);
            this.loading = false;
          });
      this.done = true;
    }
  }

  register() {
    this.loading = true;

    let tempCompany: Company;
    this.obsCompany
      .subscribe((data: Company) => {
        tempCompany = data;
        if(tempCompany.nip != this.company.nip){
          this.companyOk = true;
          this.checkUser();
        } else {
          this.alertService.error('Firma została już zarejestrowana pod tym nr NIP');
          this.error = true;
        }
      });

    this.userOk = false;
    this.companyOk = false;

    this.done = false;
    this.loading = false;
  }
}
