import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {AdminService} from "../admin.service";
import {VatGroup} from "../../_models/vatGroup";
import {NavbarService} from "../../general/navigation/app-nav.service";

@Component({
  selector: 'vat-group-overview',
  template: require('./vat-group-overview.component.html!text'),
  providers: [AdminService]
} as Component)
export class VatGroupOverviewComponent implements OnInit {
  public currentGroups: VatGroup[];

  constructor(public nav: NavbarService, private adminService: AdminService, private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.nav.show();
    this.currentGroups = this.route.snapshot.data['VGroups'];
  }
}
