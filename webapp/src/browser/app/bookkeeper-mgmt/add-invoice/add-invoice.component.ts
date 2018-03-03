import {Component, OnInit} from "@angular/core";
import {NavbarService} from "../../general/navigation/app-nav.service";
import {ActivatedRoute, Router} from "@angular/router";
import {AlertService} from "../../_services/alert.service";
import {BookKeeperService} from "../bookkeeper.service";
import {Company} from "../../_models/company";
import {InvoiceRow} from "../../_models/invoiceRow";
import {User} from "../../_models/user";
import {VatGroup} from "../../_models/vatGroup";
import {forEach} from "@angular/router/src/utils/collection";
import {Item} from "../../_models/item";


@Component({
  moduleId: module.id,
  templateUrl: 'add-invoice.component.html'
})

export class AddInvoiceComponent implements OnInit {
  model: any = {};
  row: any = {};
  rows: InvoiceRow[];
  defItems: Item[] = [];
  loading = false;
  dateTime: any;
  currCompany: Company;
  issuer: User;
  vatGroups: VatGroup[];
  defItemModel: any = {};


  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private bookKeeperService: BookKeeperService,
    private alertService: AlertService,
    public nav: NavbarService) { }

  ngOnInit() {
    this.nav.show();
    this.row = {};
    this.rows = [];
    this.defItems = [];
    this.vatGroups = this.route.snapshot.data['VGroups'];
    this.defItems = this.route.snapshot.data['Merchandise'];
    this.dateTime = Date.now().toString();
    if(localStorage.getItem('currentUser')) {
      var currUser = JSON.parse(localStorage.getItem('currentUser'));
      this.issuer = currUser;
      this.currCompany = currUser.company;
    }

  }

  createInvoice() {
    this.model.invoiceNumber = this.currCompany.name.substring(0,3) + this.dateTime;
    this.model.issuer = this.issuer;
    this.loading = true;
    this.model.company = this.currCompany;
    this.model.rows = this.rows;
    var nettoTot = +0;
    var bruttoTot = +0;
    var vatTot = +0;
    this.rows.forEach(row => {
      nettoTot += +row.rowNettoTotal;
      bruttoTot += +row.rowBruttoTotal;
      vatTot += (+row.rowNettoTotal * (+row.vatGroup.taxRate / 100));
    });

    this.model.nettoTotal = nettoTot;
    this.model.bruttoTotal = bruttoTot;
    this.model.vatTotal = vatTot;

    this.bookKeeperService.createInvoice(this.model)
      .subscribe(res => {
          this.alertService.success('Zapisano fakturę', true);
          this.router.navigate(['Invoices']);
        },
        error => {
          this.alertService.error(error);
          this.loading = false;
        })
  }

  addRow() {
    this.row.bruttoItemPrice = +this.row.nettoItemPrice * (+this.row.vatGroup.taxRate +100) / 100;
    this.row.rowNettoTotal = +this.row.nettoItemPrice * +this.row.itemAmount;
    this.row.rowBruttoTotal = +this.row.bruttoItemPrice  * +this.row.itemAmount;
    var pushRow = <InvoiceRow> JSON.parse(JSON.stringify(this.row));
    this.rows = this.rows.concat(pushRow);
  }

  addDefinedMerch() {
    var merchRow = new InvoiceRow();
    merchRow.itemName = this.defItemModel.merch.name;
    merchRow.nettoItemPrice = this.defItemModel.merch.nettoPrice;
    merchRow.bruttoItemPrice = +this.defItemModel.merch.nettoPrice * (this.defItemModel.merch.vatGroup.taxRate / 100) + +this.defItemModel.merch.nettoPrice;
    merchRow.itemUnit = this.defItemModel.merch.unit;
    merchRow.itemAmount = this.defItemModel.amount;
    merchRow.vatGroup = this.defItemModel.merch.vatGroup;
    merchRow.rowNettoTotal = +this.defItemModel.merch.nettoPrice * +this.defItemModel.amount;
    merchRow.rowBruttoTotal = +merchRow.bruttoItemPrice * +this.defItemModel.amount;
    var pushRow = <InvoiceRow> JSON.parse(JSON.stringify(merchRow));
    this.rows = this.rows.concat(pushRow);
  }
}
// itemName: string; //
// nettoItemPrice: number; //
// bruttoItemPrice: number;
// itemUnit: string; //
// itemAmount: number; // V
// rowNettoTotal: number;
// rowBruttoTotal: number;
// vatGroup: VatGroup;
