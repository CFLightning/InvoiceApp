import {Component, OnInit} from "@angular/core";
import {NavbarService} from "../../general/navigation/app-nav.service";
import {ActivatedRoute, Router} from "@angular/router";
import {AlertService} from "../../_services/alert.service";
import {Summary} from "../../_models/summary";
import * as jsPDF from "jspdf";





@Component({
  moduleId: module.id,
  templateUrl: 'invoice-details.component.html'
})

export class InvoiceDetailsComponent implements OnInit {

  currInv: any;
  summaries: Summary[] = [];
  doc: any = new jsPDF();

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private alertService: AlertService,
    public nav: NavbarService) { }

  ngOnInit() {
    this.nav.show();

    if(localStorage.getItem('currentUser')) {
      this.currInv = JSON.parse(localStorage.getItem('currentInvoice'));
    }

    //var doc = new jsPDF();
    this.doc.setFontSize(14);
    this.doc.text(12, 10, 'Nr faktury: ' + this.currInv.invoiceNumber);
    this.doc.text(12, 15, 'Wystawiajacy: ' + this.currInv.issuer.name + ' ' + this.currInv.issuer.surname);
    this.doc.text(12, 25, 'Data wystawienia: ' + this.currInv.issueDate);
    this.doc.text(12, 30, 'Data sprzedazy: ' + this.currInv.issueDate);
    this.doc.setFontSize(24);
    this.doc.text(80, 45, 'Faktura VAT');
    this.doc.setFontSize(18);
    this.doc.text(12, 65, 'Sprzedawca');
    this.doc.text(120, 65, 'Kupujacy');
    this.doc.setFontSize(14);
    this.doc.text(12, 75, this.currInv.company.name);
    this.doc.text(12, 80, 'NIP: ' + this.currInv.company.nip);
    this.doc.text(12, 85, this.currInv.company.address + ', ' + this.currInv.company.postalCode + ', ' + this.currInv.company.city);
    this.doc.text(120, 75, this.currInv.buyerName);
    this.doc.text(120, 80, 'NIP: ' + this.currInv.buyerNIP);
    this.doc.text(120, 85, this.currInv.buyerAddress + ', ' + this.currInv.buyerPostalCode + ', ' + this.currInv.buyerCity);
    this.doc.setFontSize(10);
    this.doc.text(12, 95, 'Nazwa');
    this.doc.text(33, 95, 'Cena\nNetto');
    this.doc.text(50, 95, 'Cena\nBrutto');
    this.doc.text(70, 95, 'Cena\nVAT');
    this.doc.text(87, 95, 'Jednostka');
    this.doc.text(105, 95, 'Ilosc');
    this.doc.text(114, 95, 'Grupa\nVAT');
    this.doc.text(133, 95, 'Calosc\nNetto');
    this.doc.text(154, 95, 'Calosc\nBrutto');
    this.doc.text(178, 95, 'Calosc\nVAT');
    var counter = +0;
    this.doc.setFontSize(9);
    this.currInv.rows.forEach(row => {
      this.doc.text(12,105+counter, row.itemName);
      this.doc.text(33,105+counter, row.nettoItemPrice.toString() + 'zl');
      this.doc.text(50,105+counter, row.bruttoItemPrice.toString() + 'zl');
      this.doc.text(70,105+counter, (row.nettoItemPrice * (row.vatGroup.taxRate /100)).toString() + 'zl');
      this.doc.text(87,105+counter, row.itemUnit);
      this.doc.text(105,105+counter, row.itemAmount.toString());
      this.doc.text(114,105+counter, row.vatGroup.name);
      this.doc.text(133,105+counter, row.rowNettoTotal.toString() + 'zl');
      this.doc.text(154,105+counter, row.rowBruttoTotal.toString() + 'zl');
      this.doc.text(178,105+counter, (row.rowNettoTotal * (row.vatGroup.taxRate / 100)).toString() + 'zl');
      if (this.summaries.some(x => x.sumTaxRate === row.vatGroup.taxRate))
      {
        var sum = this.summaries.find(x => x.sumTaxRate === row.vatGroup.taxRate);
        sum.sumNetto += row.rowNettoTotal;
        sum.sumBrutto += row.rowBruttoTotal;
        sum.sumVat += (row.rowNettoTotal * (row.vatGroup.taxRate / 100));
      }
      else
      {
        var pushSum = new Summary(row.vatGroup.taxRate, row.rowNettoTotal, row.rowNettoTotal * (row.vatGroup.taxRate / 100), row.rowBruttoTotal);
        var copySum = <Summary> JSON.parse(JSON.stringify(pushSum));
        this.summaries = this.summaries.concat(copySum);
      }
      counter += 5;
    });
    counter = +0;
    this.doc.setFontSize(10);
    this.doc.text(12, 160, 'Stawka');
    this.doc.text(33, 160, 'Kwota\nNetto');
    this.doc.text(50, 160, 'Kwota\nBrutto');
    this.doc.text(70, 160, 'Kwota\nVAT');
    this.doc.setFontSize(9);
    this.summaries.forEach(sum => {
      this.doc.text(12, 170+counter, sum.sumTaxRate.toString() + '%');
      this.doc.text(33, 170+counter, sum.sumNetto.toString() + 'zl');
      this.doc.text(50, 170+counter, sum.sumBrutto.toString() + 'zl');
      this.doc.text(70, 170+counter, sum.sumVat.toString() + 'zl');
      counter += 5;
    });
    this.doc.text(12, 175+counter, 'SUMA');
    this.doc.text(33, 175+counter, this.currInv.nettoTotal + 'zl');
    this.doc.text(50, 175+counter, this.currInv.bruttoTotal + 'zl');
    this.doc.text(70, 175+counter, this.currInv.vatTotal + 'zl');
    this.doc.setFontSize(14);
    this.doc.text(12, 200, 'Nr konta: ' + this.currInv.company.bankAccount);
  }

  downloadPdf() {

    this.doc.save('test.pdf');
  }
}

