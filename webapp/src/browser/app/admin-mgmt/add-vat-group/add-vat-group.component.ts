import {Component, OnInit} from "@angular/core";
import {NavbarService} from "../../general/navigation/app-nav.service";
import {ActivatedRoute, Router} from "@angular/router";
import {AlertService} from "../../_services/alert.service";
import {AdminService} from "../admin.service";

@Component({
  moduleId: module.id,
  templateUrl: 'add-vat-group.component.html'
})

export class AddVatGroupComponent implements OnInit {
  model: any = {};
  loading = false;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private adminService: AdminService,
    private alertService: AlertService,
    public nav: NavbarService) { }

    ngOnInit() {
      this.nav.show();
    }

    createVatGroup() {
      this.loading = true;
      this.adminService.createGroup(this.model)
        .subscribe(res => {
          this.alertService.success('Utworzono grupę VAT', true);
          this.router.navigate(['VGroups']);
        },
        error => {
          this.alertService.error(error);
          this.loading = false;
        })
    }
}
