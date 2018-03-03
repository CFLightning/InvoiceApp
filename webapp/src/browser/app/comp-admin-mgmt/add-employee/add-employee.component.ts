import {Component, OnInit} from "@angular/core";
import {NavbarService} from "../../general/navigation/app-nav.service";
import {ActivatedRoute, Router} from "@angular/router";
import {AlertService} from "../../_services/alert.service";
import {CompAdminService} from "../comp-admin.service";
import {UserService} from "../../_services/user.service";
import {User} from "../../_models/user";

@Component({
  moduleId: module.id,
  templateUrl: 'add-employee.component.html'
})

export class AddEmployeeComponent implements OnInit {
  model: any = {};
  loading = false;
  obsUser: any;
  currUser: any;
  currentEmployees: User[];

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private alertService: AlertService,
    private compAdminService: CompAdminService,
    private userService: UserService,
    public nav: NavbarService) { }

  ngOnInit() {
    this.nav.show();
    this.obsUser = this.userService.find(this.model);
    this.currentEmployees = this.route.snapshot.data['Employees'];
    if(localStorage.getItem('currentUser')) {
      this.currUser = JSON.parse(localStorage.getItem('currentUser'));
    }
  }

  createEmployee() {
    this.loading = true;

    let tempUser: User;
    this.obsUser
      .subscribe((data: User) => {
        tempUser = data;
        if(tempUser.login != this.model.login){
          this.registerUser();
        } else {
          this.alertService.error('Nazwa użytkownika zajęta');
        }
      });

    this.loading = false;
  }

  registerUser() {
    this.model.company = this.currUser.company;
    this.model.accountType = 3;
    this.userService.create(this.model)
      .subscribe(
        data => {
          this.alertService.success('Rejestracja zakończona powodzeniem', true);
          this.currentEmployees = this.currentEmployees.concat(this.model);
        },
        error => {
          this.alertService.error(error);
          this.loading = false;
        });
  }
}
