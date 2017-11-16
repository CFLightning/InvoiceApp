import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import {AlertService} from "../_services/alert.service";
import {AuthenticationService} from "../_services/authentication.service";
import {AppNavComponent} from "../general/navigation/app-nav.component";
import {NavbarService} from "../general/navigation/app-nav.service";


@Component({
  moduleId: module.id,
  templateUrl: 'login.component.html'
})

export class LoginComponent implements OnInit {
  model: any = {};
  loading = false;
  returnUrl: string;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private authenticationService: AuthenticationService,
    private alertService: AlertService,
    public nav: NavbarService) { }

  ngOnInit() {
    this.nav.hide();
    // reset login status
    this.authenticationService.logout();

    // get return url from route parameters or default to '/'
    this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
  }

  login() {
    this.loading = true;
    this.authenticationService.login(this.model.username, this.model.password)
      .subscribe(
        data => {
          this.router.navigate(['book-mgmt/books']);
          this.nav.show();
          this.nav.setUser();
        },
        error => {
          this.alertService.error("Username or password incorrect");
          this.loading = false;
       });

  }
}
