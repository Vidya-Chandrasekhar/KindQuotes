import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import {HomeService} from '../home/homeService';
import {Quote} from "../../model/quote";

/**
 * Generated class for the AddQuotePage page.
 *
 * See http://ionicframework.com/docs/components/#navigation for more info
 * on Ionic pages and navigation.
 */
@IonicPage()
@Component({
  selector: 'page-add-quote',
  templateUrl: 'add-quote.html',
  providers:[HomeService]
})
export class AddQuotePage {

  constructor(public navCtrl: NavController, public navParams: NavParams, public homeService: HomeService) {
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad AddQuotePage');
  }

  addQuote(message: String){
    var quote = new Quote();
    quote.setMessage(message);
    this.homeService.addANewQuote(quote).subscribe(data => {
      console.log(data);
    });
}
}
