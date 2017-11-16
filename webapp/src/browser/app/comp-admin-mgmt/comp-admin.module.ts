import {NgModule} from '@angular/core';
import {RouterModule} from '@angular/router';
import {FormsModule} from '@angular/forms';
import {CommonModule} from '@angular/common';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {CompAdminService} from "./comp-admin.service";
import {AddEmployeeComponent} from "./add-employee/add-employee.component";
import {EmployeeResolver} from "./comp-employees-resolver";

@NgModule({
  imports: [CommonModule, RouterModule, FormsModule, NgbModule],
  declarations: [AddEmployeeComponent],
  exports: [AddEmployeeComponent],
  providers: [CompAdminService, EmployeeResolver]
} as NgModule)
export class CompAdminModule {
}
