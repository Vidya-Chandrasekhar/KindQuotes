import { Component } from '@angular/core';
import { NavController } from 'ionic-angular';
import {HomeService} from './homeService';
import {Http} from '@angular/http';
import {AddQuotePage} from "../add-quote/add-quote";

@Component({
  selector: 'page-home',
  templateUrl: 'home.html',
  providers:[HomeService]
})
export class HomePage {

  quotes: any;

  constructor(public navCtrl: NavController, public homeService:HomeService) {
    homeService.getAllQuotes().subscribe(data =>{
      this.quotes = data;
    })
  }

  addQuote(){
    this.navCtrl.push(AddQuotePage);
  }

}
