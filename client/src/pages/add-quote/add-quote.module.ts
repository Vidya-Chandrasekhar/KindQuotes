import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { AddQuotePage } from './add-quote';

@NgModule({
  declarations: [
    AddQuotePage,
  ],
  imports: [
    IonicPageModule.forChild(AddQuotePage),
  ],
  exports: [
    AddQuotePage
  ]
})
export class AddQuotePageModule {}
