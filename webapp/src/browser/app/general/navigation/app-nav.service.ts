import { Injectable } from '@angular/core';

@Injectable()
export class NavbarService {
  visible: boolean;
  sysAdmin: boolean = false;
  compAdmin: boolean = false;
  bookKeeper: boolean = false;

  constructor() { this.visible = true; }

  hide() { this.visible = false; }

  show() { this.visible = true; }

  toggle() { this.visible = !this.visible; }

  setUser() {
    if(localStorage.getItem('currentUser')) {
      var currUser = JSON.parse(localStorage.getItem('currentUser'));
      if(currUser.accountType == 1){
        this.sysAdmin = true;
        this.compAdmin = false;
        this.bookKeeper = false;
      }
      else if(currUser.accountType == 2) {
        this.sysAdmin = false;
        this.compAdmin = true;
        this.bookKeeper = false;
      }
      else if(currUser.accountType == 3) {
        this.sysAdmin = false;
        this.compAdmin = false;
        this.bookKeeper = true;
      }
    }
  }

}
