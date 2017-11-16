import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {AppComponent} from './app.component';
import {GeneralModule} from './general/general.module';
import {BookMgmtModule} from './book-mgmt/book-mgmt.module';
import {routing} from './app.routing';

import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {AlertComponent} from "./_directives/alert.component";
import {AlertService} from "./_services/alert.service";
import {LoginComponent} from "./login/login.component";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {AuthenticationService} from "./_services/authentication.service";
import {HttpModule} from "@angular/http";
import {RegisterComponent} from "./register/register.component";
import {UserService} from "./_services/user.service";
import {NavbarService} from "./general/navigation/app-nav.service";
import {AuthGuard} from "./_guards/auth.guard";
import {CompanyService} from "./_services/company.service";
import {AdminModule} from "./admin-mgmt/admin.module";
import {AdminService} from "./admin-mgmt/admin.service";
import {CompAdminModule} from "./comp-admin-mgmt/comp-admin.module";

@NgModule({
  imports: [BrowserModule, HttpModule, AdminModule, CompAdminModule, BookMgmtModule, GeneralModule, routing, NgbModule.forRoot(), FormsModule, ReactiveFormsModule],
  declarations: [AppComponent, AlertComponent, LoginComponent, RegisterComponent],
  providers: [AlertService, AdminService, AuthenticationService, CompanyService, UserService, NavbarService, AuthGuard],
  bootstrap: [AppComponent]
} as NgModule)
export class AppModule {
}
