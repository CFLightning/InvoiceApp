import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {AdminService} from "../admin.service";
import {VatGroup} from "../../_models/vatGroup";

@Component({
  selector: 'vat-group-overview',
  template: require('./vat-group-overview.component.html!text'),
  providers: [AdminService]
} as Component)
export class VatGroupOverviewComponent implements OnInit {
  public currentGroups: VatGroup[];

  constructor(private adminService: AdminService, private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.currentGroups = this.route.snapshot.data['VGroups'];
  }
}
