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
import {MerchandiseOverviewComponent} from "./bookkeeper-mgmt/view-merchandise/view-merchandise.component";
import {MerchResolver} from "./bookkeeper-mgmt/merch-resolver";
import {AddMerchandiseComponent} from "./bookkeeper-mgmt/add-merchandise/add-merchandise.component";
import {ViewInvoicesComponent} from "./bookkeeper-mgmt/view-invoices/view-invoices.component";
import {InvoiceResolver} from "./bookkeeper-mgmt/invoice-resolver";
import {AddInvoiceComponent} from "./bookkeeper-mgmt/add-invoice/add-invoice.component";
import {InvoiceDetailsComponent} from "./bookkeeper-mgmt/invoice-details/invoice-details.component";

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
    path: 'Merchandise',
    component: MerchandiseOverviewComponent,
    resolve: {
      Merchandise: MerchResolver
    }
  },
  {
    path: 'Invoices',
    component: ViewInvoicesComponent,
    resolve: {
      Invoices: InvoiceResolver
    }
  },
  {
    path: 'Invoice',
    component: AddInvoiceComponent,
    resolve: {
      VGroups: VatGroupResolver,
      Merchandise: MerchResolver
    }
  },
  {
    path: 'InvoiceDetails',
    component: InvoiceDetailsComponent
  },
  {
    path: 'AddMerch',
    component: AddMerchandiseComponent,
    resolve: {
      VGroups: VatGroupResolver
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
