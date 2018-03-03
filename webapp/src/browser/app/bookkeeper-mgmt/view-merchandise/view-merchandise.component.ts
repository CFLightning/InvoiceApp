import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {BookKeeperService} from "../bookkeeper.service";
import {Item} from "../../_models/item";
import {NavbarService} from "../../general/navigation/app-nav.service";

@Component({
  selector: 'view-merchandise',
  template: require('./view-merchandise.component.html!text'),
  providers: [BookKeeperService]
} as Component)
export class MerchandiseOverviewComponent implements OnInit {
  public currentMerch: Item[];

  constructor(public nav: NavbarService, private bookKeeperService: BookKeeperService, private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.nav.show();
    this.currentMerch = this.route.snapshot.data['Merchandise'];
  }
}
