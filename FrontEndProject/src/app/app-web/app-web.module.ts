import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AgGridModule } from 'ag-grid-angular';
import { ClasseComponent } from '../../app/app-web/enseignant/classe/classe.component';
import { BrowserModule } from '@angular/platform-browser';
import { MaterialModule } from '../../modules/material/material.module';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

@NgModule({
  imports: [
    CommonModule,
  [BrowserModule, AgGridModule.withComponents([])],
  MaterialModule,
  BrowserModule,
    HttpClientModule,
    FormsModule,
    BrowserAnimationsModule,
  
 
  ],
  providers: [],
  bootstrap: [ClasseComponent],
  declarations: [
  ClasseComponent,
  ]
})
export class AppWebModule { }
