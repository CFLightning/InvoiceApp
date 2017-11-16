import {ModuleWithProviders} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {BookOverviewComponent} from './book-mgmt/book-overview/book-overview.component';
import {BookDetailsComponent} from './book-mgmt/book-details/book-details.component';
import {LoginComponent} from "./login/login.component";
import {RegisterComponent} from "./register/register.component";
import {AuthGuard} from "./_guards/auth.guard";
import {VatGroupOverviewComponent} from "./admin-mgmt/vat-group-overview/vat-group-overview.component";
import {VatGroupResolver} from "./admin-mgmt/vat-group-resolver";
import {AddVatGroupComponent} from "./admin-mgmt/add-vat-group/add-vat-group.component";
import {AddEmployeeComponent} from "./comp-admin-mgmt/add-employee/add-employee.component";
import {EmployeeResolver} from "./comp-admin-mgmt/comp-employees-resolver";

const appRoutes: Routes = [
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'register',
    component: RegisterComponent
  },
  {
    path: 'VGroups',
    component: VatGroupOverviewComponent,
    resolve: {
      VGroups: VatGroupResolver
    }
  },
  {
    path: 'VGroup',
    component: AddVatGroupComponent
  },
  {
    path: 'Employees',
    component: AddEmployeeComponent,
    resolve: {
      Employees: EmployeeResolver
    }
  },
  {
    path: 'book-mgmt/books',
    component: BookOverviewComponent,
    canActivate: [AuthGuard],
  },
  {
    path: 'book-mgmt/book',
    component: BookDetailsComponent
  },
  {
    path: 'book-mgmt/book/:bookId',
    component: BookDetailsComponent
  },
  {
    path: '**',
    redirectTo: 'login',
  }
] as Routes;

export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);
