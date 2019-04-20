import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AgGridModule } from 'ag-grid-angular';
import { ClasseComponent } from '../../app/app-web/enseignant/classe/classe.component';




@NgModule({
  imports: [
    CommonModule,
    AgGridModule,


  ],
  declarations: [
  ClasseComponent,


  ]
})
export class AppWebModule { }
