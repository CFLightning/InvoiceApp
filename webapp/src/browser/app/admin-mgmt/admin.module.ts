import {NgModule} from '@angular/core';
import {RouterModule} from '@angular/router';
import {FormsModule} from '@angular/forms';
import {CommonModule} from '@angular/common';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {AdminService} from "./admin.service";
import {VatGroupOverviewComponent} from "./vat-group-overview/vat-group-overview.component";
import {AddVatGroupComponent} from "./add-vat-group/add-vat-group.component";
import {VatGroupResolver} from "./vat-group-resolver";

@NgModule({
  imports: [CommonModule, RouterModule, FormsModule, NgbModule],
  declarations: [VatGroupOverviewComponent, AddVatGroupComponent],
  exports: [VatGroupOverviewComponent, AddVatGroupComponent],
  providers: [AdminService, VatGroupResolver]
} as NgModule)
export class AdminModule {
}
