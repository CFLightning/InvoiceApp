import {NgModule} from '@angular/core';
import {RouterModule} from '@angular/router';
import {FormsModule} from '@angular/forms';
import {CommonModule} from '@angular/common';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {BookKeeperService} from "./bookkeeper.service";
import {MerchResolver} from "./merch-resolver";
import {MerchandiseOverviewComponent} from "./view-merchandise/view-merchandise.component";
import {AddMerchandiseComponent} from "./add-merchandise/add-merchandise.component";
import {ViewInvoicesComponent} from "./view-invoices/view-invoices.component";
import {InvoiceResolver} from "./invoice-resolver";
import {AddInvoiceComponent} from "./add-invoice/add-invoice.component";
import {InvoiceDetailsComponent} from "./invoice-details/invoice-details.component";
import {PdfmakeModule} from "ng-pdf-make";

@NgModule({
  imports: [CommonModule, RouterModule, FormsModule, NgbModule],
  declarations: [InvoiceDetailsComponent, AddInvoiceComponent, ViewInvoicesComponent, MerchandiseOverviewComponent, AddMerchandiseComponent],
  exports: [InvoiceDetailsComponent, AddInvoiceComponent, ViewInvoicesComponent, MerchandiseOverviewComponent, AddMerchandiseComponent],
  providers: [BookKeeperService, MerchResolver, InvoiceResolver]
} as NgModule)
export class BookKeeperModule {
}
