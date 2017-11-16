import {Component, OnInit} from '@angular/core';
import {NavbarService} from "./app-nav.service";
import {AuthenticationService} from "../../_services/authentication.service";

@Component({
  selector: 'app-nav',
  template: require('./app-nav.component.html!text')
} as Component)
export class AppNavComponent{
  navCollapsed: boolean = true;


  constructor(public nav: NavbarService, private auth: AuthenticationService) {}

  toggleNavigation(): void {
    this.navCollapsed = !this.navCollapsed;
  };
}
