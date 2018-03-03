import {Component, OnInit} from "@angular/core";
import {NavbarService} from "../../general/navigation/app-nav.service";
import {ActivatedRoute, Router} from "@angular/router";
import {AlertService} from "../../_services/alert.service";
import {BookKeeperService} from "../bookkeeper.service";
import {Company} from "../../_models/company";
import {InvoiceHead} from "../../_models/invoiceHead";

@Component({
  moduleId: module.id,
  templateUrl: 'view-invoices.component.html'
})

export class ViewInvoicesComponent implements OnInit {
  invoices: InvoiceHead[];
  currCompany: Company;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private bookKeeperService: BookKeeperService,
    private alertService: AlertService,
    public nav: NavbarService) { }

  ngOnInit() {
    this.nav.show();
    this.invoices = this.route.snapshot.data['Invoices'];
    if (localStorage.getItem('currentUser')) {
      var currUser = JSON.parse(localStorage.getItem('currentUser'));
      this.currCompany = currUser.company;
    }
  }

  invoiceDetails(invoice: InvoiceHead) {
    localStorage.setItem('currentInvoice', JSON.stringify(invoice));
    this.router.navigate(['InvoiceDetails']);
  }
}
