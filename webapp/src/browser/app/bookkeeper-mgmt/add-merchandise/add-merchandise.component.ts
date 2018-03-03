import {Component, OnInit} from "@angular/core";
import {NavbarService} from "../../general/navigation/app-nav.service";
import {ActivatedRoute, Router} from "@angular/router";
import {AlertService} from "../../_services/alert.service";
import {BookKeeperService} from "../bookkeeper.service";
import {VatGroup} from "../../_models/vatGroup";
import {Company} from "../../_models/company";

@Component({
  moduleId: module.id,
  templateUrl: 'add-merchandise.component.html'
})

export class AddMerchandiseComponent implements OnInit {
  model: any = {};
  loading = false;
  vatGroups: VatGroup[];
  currCompany: Company;
  brutto: number;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private bookKeeperService: BookKeeperService,
    private alertService: AlertService,
    public nav: NavbarService) { }

  ngOnInit() {
    this.nav.show();
    this.vatGroups = this.route.snapshot.data['VGroups']
    if(localStorage.getItem('currentUser')) {
      var currUser = JSON.parse(localStorage.getItem('currentUser'));
      this.currCompany = currUser.company;
    }

  }

  createItem() {
    this.loading = true;
    this.model.company = this.currCompany;
    this.bookKeeperService.createItem(this.model)
      .subscribe(res => {
          this.alertService.success('Zapisano towar lub usługę', true);
          this.router.navigate(['Merchandise']);
        },
        error => {
          this.alertService.error(error);
          this.loading = false;
        })
  }
}
