import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AgGridModule } from 'ag-grid-angular';
import { ClasseComponent } from '../../app/app-web/enseignant/classe/classe.component';
import { BrowserModule } from '@angular/platform-browser';
import { MatSelectModule, MatCheckboxModule, MatButtonModule, MatFormFieldModule, MatInputModule } from '@angular/material';

@NgModule({
  imports: [
    CommonModule,
  [BrowserModule, AgGridModule.withComponents([])],
  MatSelectModule,
  MatButtonModule,
  MatCheckboxModule,
  MatFormFieldModule,
  MatSelectModule,
  MatInputModule,
  ],
  providers: [],
  bootstrap: [ClasseComponent],
  declarations: [
  ClasseComponent,
  ]
})
export class AppWebModule { }
